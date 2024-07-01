package com.example.quizapp.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.quizapp.presentation.ColorProvider
import com.example.quizapp.presentation.QuestionP
import com.example.quizapp.presentation.StateQz

@Composable
fun ProgressOfQuestions(list : List<QuestionP>) {
    Row(
        modifier = Modifier.fillMaxWidth().height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        list.forEach {
            Box(
                modifier = Modifier.fillMaxHeight().width(38.dp)
                    .clip(CircleShape).background(
                        ColorProvider.calcColor(it)
                    )
            )
        }
    }
}