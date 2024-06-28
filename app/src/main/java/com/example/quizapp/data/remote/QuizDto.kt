package com.example.quizapp.data.remote

import com.example.quizapp.domain.QuestionD
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
    fun toDomain(): QuestionD {
        val temp = (incorrectAnswers + correctAnswer).shuffled().toList()
        return QuestionD(
            correctAnswer = correctAnswer,
            answers = temp,
            question = question.text
        )
    }
}
data class Question (

    @SerializedName("text" ) val text : String

)
