package com.example.quizapp.domain

interface CargoD {

    fun <T : Any> combine(mapper: Mapper<T>, prev: T): T

    interface Mapper<T : Any> {

        fun onLoading(boolean: Boolean, prev: T): T
        fun onFail(mess: String, prev: T): T
        fun onSuccess(list: List<QuestionD>, prev: T): T
    }

    data class Loading(private val isLoading: Boolean) : CargoD {
        override fun <T : Any> combine(mapper: Mapper<T>, prev: T): T =
            mapper.onLoading(isLoading, prev)
    }

    data class Fail(private val mess: String) : CargoD {
        override fun <T : Any> combine(mapper: Mapper<T>, prev: T): T =
            mapper.onFail(mess, prev)
    }

    data class Success(private val list: List<QuestionD>) : CargoD {
        override fun <T : Any> combine(mapper: Mapper<T>, prev: T): T =
            mapper.onSuccess(list, prev)
    }
}