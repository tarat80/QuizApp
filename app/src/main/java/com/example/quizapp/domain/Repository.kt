package com.example.quizapp.domain

import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun cashQuiz() : Flow<CargoD>

    suspend fun insert(questionD: QuestionD)

    fun getCashed(): Flow<CargoD>


}