package com.example.quizapp.application

import android.app.Application
import androidx.room.Room
import com.example.quizapp.data.local.Converter
import com.example.quizapp.data.local.QuizDataBase
import com.example.quizapp.data.remote.QuizApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideRetrofitApi(): QuizApi {
        return Retrofit.Builder()
            .baseUrl("https://the-trivia-api.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuizApi::class.java)
    }
    @Provides
    @Singleton
    fun provideDbQuoteDao(app: Application) = Room
        .databaseBuilder(
            app,
            QuizDataBase::class.java, "quiz.db")
        .fallbackToDestructiveMigration()
        .addTypeConverter(Converter())
        .build()
        .quizDao()
}