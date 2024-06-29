package com.example.quizapp.presentation

interface Cargo1 {

    interface Deliver1{

        fun onButtonClk(pickedAnswer :String)
    }


    data class ButtonClk(
        private val isRight : Boolean
    )
}