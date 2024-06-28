package com.example.quizapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.domain.CargoD
import com.example.quizapp.domain.Repository
import kotlinx.coroutines.launch

class QzViewModel(
    private val repository: Repository,
    private val mapper : CargoD.Mapper<State>
) : ViewModel(){

    init{
       viewModelScope.launch {
        repository.getQz().collect{
            state= it.combine(mapper,state)
        }
       }
    }

    var state by mutableStateOf(State())
        private set


}