package com.example.quizapp.domain

data class QuestionD(
    val correctAnswer: String,
    val answers: List<String>,
    val question: String
)
