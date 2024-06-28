package com.example.quizapp.data.remote

import com.example.quizapp.domain.QuestionD
import com.google.gson.annotations.SerializedName

data class QuizDto(
    @SerializedName("results"       ) val results      : List<Question>
)

data class Question (
    @SerializedName("type"              ) val type             : String,
    @SerializedName("difficulty"        ) val difficulty       : String,
    @SerializedName("category"          ) val category         : String,
    @SerializedName("question"          ) val question         : String,
    @SerializedName("correct_answer"    ) val correctAnswer    : String,
    @SerializedName("incorrect_answers" ) val incorrectAnswers : List<String>
){
    fun toDomain(): QuestionD {
        return QuestionD(
            type,difficulty,category,question,correctAnswer,incorrectAnswers
        )
    }
}