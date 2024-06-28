package com.example.quizapp.application

import com.example.quizapp.data.RepositoryImpl
import com.example.quizapp.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindData {
    @Binds
    @Singleton
    abstract fun bindRep(repositoryImpl: RepositoryImpl): Repository
}