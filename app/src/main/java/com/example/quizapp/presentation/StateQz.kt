package com.example.quizapp.presentation

data class StateQz(
    val listQz: List<QuestionP> = listOf(),
    val isLoading : Boolean =false,
    val errorMsg : String ="",
    val currentQuestion : Int =0
)
