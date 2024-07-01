package com.example.quizapp.presentation

import com.example.quizapp.domain.QuestionD

data class QuestionP(
    val id :Int,
    val correctAnswer: String,
    val answers: List<String>,
    val question: String,
    val isAnswered : Boolean,
    val isRight : Boolean
){
    fun toQuestionD() =
        QuestionD(id,correctAnswer,answers,question,isAnswered,isRight)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as QuestionP

        if (id != other.id) return false
        if (isAnswered != other.isAnswered) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + isAnswered.hashCode()
        return result
    }
}
