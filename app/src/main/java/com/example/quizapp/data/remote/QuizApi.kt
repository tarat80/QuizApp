package com.example.quizapp.data.remote

import retrofit2.http.GET

interface QuizApi {

    @GET("https://opentdb.com/api.php?amount=10")
    suspend fun getQuiz() : QuizDto

}