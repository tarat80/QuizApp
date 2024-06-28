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

@HiltViewModel
class QzViewModel @Inject constructor(
    private val repository: Repository,
    private val mapper: CargoD.Mapper<StateQz>
) : ViewModel() {
    var stateQz by mutableStateOf(StateQz())
        private set

    init {
        viewModelScope.launch {
            repository.getQz().collect {
                stateQz = it.combine(mapper = mapper, prev = stateQz)
            }
        }
    }
}