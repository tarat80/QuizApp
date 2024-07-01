package com.example.quizapp.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.quizapp.presentation.QuestionP

@Composable
fun Screen3(list: List<QuestionP>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        list.forEach {
            Text(
                text =
                it.id.toString()
                        + it.isAnswered.toString()
                        + it.isRight.toString()
            )
        }
    }
}