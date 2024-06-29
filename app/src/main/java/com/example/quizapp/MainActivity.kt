package com.example.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.presentation.QzViewModel
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
                        startDestination = Screen1
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
                                val current = state.listQz[state.currentQuestion]
                                Text(
                                    modifier = Modifier.fillMaxWidth(0.8f),
                                    text = current.question
                                )
                                current.answers.forEach {
                                    Button(
                                        onClick = {
                                            if (state.currentQuestion == 9) {
                                                navController.navigate(Screen3)
                                            } else {
                                                vieModel.onButtonClk(it)
                                            }
                                        },
                                        Modifier.fillMaxWidth(0.7f)
                                    ) {
                                        Text(text = it)
                                    }
                                }
                            }
                            //    val args = it.toRoute<ScreenB>()
                            //   Text(text = "${args.name}, ${args.age} years old")
                        }
                        composable<Screen3> {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Screen3")
                            }

                        }
                    }
                    Box(
                        modifier = Modifier.fillMaxSize(0.7f)
                    ) {
                        if (state.isLoading) CircularProgressIndicator()
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


