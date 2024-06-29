package com.example.quizapp.presentation

import com.example.quizapp.domain.QuestionD

data class QuestionP(
    val correctAnswer: String,
    val answers: List<String>,
    val question: String,
    val isAnswered : Boolean =false,
    val isRight : Boolean = false
){
    fun toQuestionD() =
        QuestionD(correctAnswer,answers,question,isAnswered,isRight)
}
