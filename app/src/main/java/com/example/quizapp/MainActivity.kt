package com.example.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.MainActivity.Screen3
import com.example.quizapp.presentation.ColorProvider
import com.example.quizapp.presentation.NUMBER_OF_QUESTIONS_PER_RUN
import com.example.quizapp.presentation.QzViewModel
import com.example.quizapp.presentation.StateQz
import com.example.quizapp.ui.theme.QuizAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizAppTheme {
                val vieModel by viewModels<QzViewModel>()
                val state = vieModel.stateQz

                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen2
                    ) {
                        composable<Screen1> {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Button(
                                    onClick = { navController.navigate(Screen2) }
                                ) {}
                            }
                        }
                        composable<Screen2> {
                            Column(
                                verticalArrangement = Arrangement.SpaceEvenly,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxHeight()
                                    .fillMaxWidth()
                                    .padding(innerPadding)
                            ) {
                                Screen2(
                                    state,
                                    navController,
                                    vieModel::onButtonClk
                                )

                            }
                            //    val args = it.toRoute<ScreenB>()
                            //   Text(text = "${args.name}, ${args.age} years old")
                        }
                        composable<Screen3> {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceAround
                            ) {
                                state.listQz.forEach {
                                    Text(
                                        text =
                                        it.id.toString()
                                                + it.isAnswered.toString()
                                                + it.isRight.toString()
                                    )
                                }
                            }

                        }
                    }

                }
            }
        }
    }

    @Serializable
    object Screen1

    @Serializable
    object Screen2

    /*data class ScreenB(
        val name: String?,
        val age: Int
    )*/
    @Serializable
    object Screen3
}

@Composable
fun Screen2(
    state: StateQz,
    navController: NavController,
    function: (String) -> Unit
) {
    if (state.isLoading)
        Box(
            modifier = Modifier.fillMaxSize()
                .background(MaterialTheme.colorScheme.secondary),
            contentAlignment = Alignment.Center,
        ) { CircularProgressIndicator() }
    else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            val current = state.listQz[state.currentQuestion]

            Text(
                modifier = Modifier.fillMaxWidth(0.8f),
                text = current.question
            )
            current.answers.forEach {
                Button(
                    onClick = {
                        function(it)
                        if (state.currentQuestion == NUMBER_OF_QUESTIONS_PER_RUN - 1)
                            navController.navigate(Screen3)
                    },
                    Modifier.fillMaxWidth(0.7f)
                ) {
                    Text(text = it)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth().height(40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                state.listQz.forEach {
                    Box(
                        modifier = Modifier.fillMaxHeight().width(38.dp)
                            .clip(CircleShape).background(
                                ColorProvider().calcColor(it)
                            )
                    ) {}
                }
            }
        }
    }
}
