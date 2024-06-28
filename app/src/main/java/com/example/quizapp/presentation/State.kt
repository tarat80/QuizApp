package com.example.quizapp.presentation

data class State(
    val listQz: List<QuestionP> = listOf(),
    val isLoading : Boolean =false,
    val errorMsg : String =""
)
