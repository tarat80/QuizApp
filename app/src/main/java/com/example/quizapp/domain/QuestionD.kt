package com.example.quizapp.domain

data class QuestionD(
    val type: String,
    val difficulty: String,
    val category: String,
    val question: String,
    val correctAnswer: String,
    val incorrectAnswers: List<String>
)
