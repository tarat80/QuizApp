package com.example.quizapp.domain

data class QuestionD(
    val id : Int,
    val correctAnswer: String,
    val answers: List<String>,
    val question: String,
    val isAnswered : Boolean =false,
    val isRight : Boolean = false
)
