package com.example.quizapp.data

import com.example.quizapp.data.remote.QuizApi
import com.example.quizapp.domain.CargoD
import com.example.quizapp.domain.Repository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val quizApi: QuizApi
) : Repository {


    override suspend fun getQz() = flow<CargoD> {
        emit(CargoD.Loading(true))
        try {
            val temp = quizApi.getQuiz().map { it.toDomain() }
            emit(CargoD.Success(temp))
        } catch (e: IOException) {
            emit(CargoD.Fail("no internet"))
        } catch (e: HttpException) {
            emit(CargoD.Fail("some error"))
        }
        emit(CargoD.Loading(false))
    }

}