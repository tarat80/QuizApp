package com.example.quizapp.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface QuizApi {

    @GET("questions/")
    suspend fun getQuiz() : List<QuizDto>

}