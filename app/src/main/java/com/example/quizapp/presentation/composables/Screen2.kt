package com.example.quizapp.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.quizapp.MainActivity
import com.example.quizapp.presentation.StateQz

@Composable
fun Screen2(
    state: StateQz,
    navController: NavController,
    function: (String) -> Unit,
    innerPadding : PaddingValues
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .padding(innerPadding)
    ) {
        LaunchedEffect(key1 = state) {
            if (state.shouldNavigate) navController.navigate(MainActivity.Screen3)
        }
        Circular(state.isLoading)

        if (!state.isLoading) Column(
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
                Item(
                    modifier = Modifier,
                    answer = it,
                    onChoose = function
                )
            }
            ProgressOfQuestions(state.listQz)
        }
    }
}