package com.example.quizapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.quizapp.domain.QuestionD


@Entity(tableName = "quiz")
data class QuizEntity(
    @PrimaryKey(autoGenerate = true)val id :Int,
    val correctAnswer: String,
    val answers: List<String>,
    val question: String,
    val isAnswered : Boolean =false,
    val isRight : Boolean = false
){
    fun toDomain(): QuestionD {
        return QuestionD(
            id = id,
            correctAnswer = correctAnswer,
            answers = answers,
            question = question,
            isAnswered= isAnswered,
            isRight = isRight
        )
    }
}