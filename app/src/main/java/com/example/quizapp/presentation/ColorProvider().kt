package com.example.quizapp.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


class ColorProvider()  {
    @Composable
    fun calcColor(questionP: QuestionP): Color {
        return if (!questionP.isAnswered) {MaterialTheme.colorScheme.secondary}
        else {if (questionP.isRight) {Color.Green.copy()}
        else Color.Red.copy()}
    }
}