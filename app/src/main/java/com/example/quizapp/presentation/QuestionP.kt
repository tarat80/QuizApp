package com.example.quizapp.presentation

data class QuestionP(
    val correctAnswer: String,
    val answers: List<String>,
    val question: String
)
