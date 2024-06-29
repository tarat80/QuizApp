package com.example.quizapp.domain

import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getQz() : Flow<CargoD>

    suspend fun insert(questionD: QuestionD)

}