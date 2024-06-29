package com.example.quizapp.data.remote

import com.example.quizapp.data.local.QuizEntity
import com.google.gson.annotations.SerializedName

data class QuizDto (
    @SerializedName("category"         ) val category         : String,
    @SerializedName("id"               ) val id               : String,
    @SerializedName("correctAnswer"    ) val correctAnswer    : String,
    @SerializedName("incorrectAnswers" ) val incorrectAnswers : ArrayList<String>,
    @SerializedName("question"         ) val question         : Question,
    @SerializedName("tags"             ) val tags             : ArrayList<String> ,
    @SerializedName("type"             ) val type             : String,
    @SerializedName("difficulty"       ) val difficulty       : String,
    @SerializedName("regions"          ) val regions          : ArrayList<String>,
    @SerializedName("isNiche"          ) val isNiche          : Boolean
)
{
    fun toDao(): QuizEntity {
        val temp = (incorrectAnswers + correctAnswer).shuffled().toList()
        return QuizEntity(
            correctAnswer = correctAnswer,
            answers = temp,
            question = question.text
        )
    }
}
data class Question (

    @SerializedName("text" ) val text : String

)
