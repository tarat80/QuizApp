package com.example.quizapp.data

import com.example.quizapp.data.local.QuizDao
import com.example.quizapp.data.local.QuizEntity
import com.example.quizapp.data.remote.QuizApi
import com.example.quizapp.domain.CargoD
import com.example.quizapp.domain.QuestionD
import com.example.quizapp.domain.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val quizApi: QuizApi,
    private val quizDao: QuizDao
) : Repository {


    override suspend fun cashQuiz() = flow<CargoD> {
        emit(CargoD.Loading(true))
        try {
            val temp = quizApi.getQuiz().map { it.toDao() }
            quizDao.deleteAll()
            quizDao.insertAll(temp)
            val temp1 =quizDao.getAll().first()
               .map { it.toDomain() }
            emit(CargoD.Success(temp1))
        } catch (e: IOException) {
            emit(CargoD.Fail("no internet"))
        } catch (e: HttpException) {
            emit(CargoD.Fail("some error"))
        }
        emit(CargoD.Loading(false))
    }

    override suspend fun insert(questionD: QuestionD) {
        quizDao.insert(toQuizEntity(questionD))
    }

    override fun getCashed(): Flow<CargoD> = flow {
        quizDao.getAll().collect{ list->
            val temp = list.map { it.toDomain() }

            emit(CargoD.Success(temp))
        }
    }
}

private fun toQuizEntity(questionD: QuestionD) = QuizEntity(
    questionD.id,
    questionD.correctAnswer,
    questionD.answers,
    questionD.question,
    questionD.isAnswered,
    questionD.isRight
)