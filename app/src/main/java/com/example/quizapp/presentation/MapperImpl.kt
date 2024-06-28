package com.example.quizapp.presentation

import com.example.quizapp.domain.CargoD
import com.example.quizapp.domain.QuestionD

class MapperImpl : CargoD.Mapper<State> {

    override fun onLoading(boolean: Boolean, prev: State): State =
        prev.copy(isLoading = boolean)

    override fun onFail(mess: String, prev: State): State =
        prev.copy(errorMsg = mess)

    override fun onSuccess(list: List<QuestionD>, prev: State): State {
        val temp = list.map { toQuestionP(it) }
        return prev.copy(listQz = temp)
    }

    private fun toQuestionP(questionD: QuestionD)=
        QuestionP(
            questionD.question,
            questionD.difficulty,
            questionD.category,
            questionD.type,
            questionD.correctAnswer,
            questionD.incorrectAnswers
            )
}