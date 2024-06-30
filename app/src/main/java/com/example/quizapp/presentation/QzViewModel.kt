package com.example.quizapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.domain.CargoD
import com.example.quizapp.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
const val NUMBER_OF_QUESTIONS_PER_RUN = 10
@HiltViewModel
class QzViewModel @Inject constructor(
    private val repository: Repository,
    private val mapper: CargoD.Mapper<StateQz>
) : ViewModel(), Cargo1.Deliver1 {
    var stateQz by mutableStateOf(StateQz())
        private set

    init {
        viewModelScope.launch {
            repository.cashQuiz().collect {
                stateQz = it.combine(mapper = mapper, prev = stateQz)
            }
            repository.getCashed().collect {
                stateQz = it.combine(mapper, prev = stateQz)
            }
        }
    }

    override fun onButtonClk(pickedAnswer: String) {
        val isRight = (pickedAnswer == stateQz
            .listQz[stateQz.currentQuestion]
            .correctAnswer)
        val current: QuestionP = stateQz.listQz[
            stateQz.currentQuestion].copy(
            isAnswered = true,
            isRight = isRight
        )
        viewModelScope.launch {
            repository.insert(current.toQuestionD())
        }
        val temp = stateQz.currentQuestion + 1
        if (temp< NUMBER_OF_QUESTIONS_PER_RUN)
            stateQz = stateQz.copy(
            currentQuestion = temp
        )
    }

}