package com.example.quizapp.presentation

import com.example.quizapp.domain.QuestionD

data class QuestionP(
    val id :Int,
    val correctAnswer: String,
    val answers: List<String>,
    val question: String,
    val isAnswered : Boolean,
    val isRight : Boolean
){
    fun toQuestionD() =
        QuestionD(id,correctAnswer,answers,question,isAnswered,isRight)
}
