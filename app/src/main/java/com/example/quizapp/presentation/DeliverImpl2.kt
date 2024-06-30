package com.example.quizapp.presentation

import com.example.quizapp.domain.CargoD
import com.example.quizapp.domain.QuestionD
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class DeliverImpl2 @Inject constructor() : CargoD.Mapper<StateQz> {

    override fun onLoading(isLoading: Boolean, prev: StateQz): StateQz =
        prev.copy(isLoading = isLoading)

    override fun onFail(mess: String, prev: StateQz): StateQz =
        prev.copy(errorMsg = mess)

    override fun onSuccess(list: List<QuestionD>, prev: StateQz): StateQz {
        val temp : List<QuestionP> = list.map { toQuestionP(it) }
        return prev.copy(listQz = temp)
    }

    private fun toQuestionP(questionD: QuestionD) =
        QuestionP(
            id =  questionD.id,
            correctAnswer = questionD.correctAnswer,
            answers = questionD.answers,
            question = questionD.question,
            isAnswered = questionD.isAnswered,
            isRight = questionD.isRight
        )
}