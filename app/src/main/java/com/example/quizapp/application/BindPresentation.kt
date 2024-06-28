package com.example.quizapp.application

import com.example.quizapp.domain.CargoD
import com.example.quizapp.presentation.MapperImpl
import com.example.quizapp.presentation.StateQz
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class BindPresentation {
    @Binds
    @ViewModelScoped
    abstract fun bindMap(mapperImpl: MapperImpl): CargoD.Mapper<StateQz>
}