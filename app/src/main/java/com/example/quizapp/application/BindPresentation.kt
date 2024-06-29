package com.example.quizapp.application

import com.example.quizapp.domain.CargoD
import com.example.quizapp.presentation.DeliverImpl2
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
    abstract fun bindMap(deliverImpl2: DeliverImpl2): CargoD.Mapper<StateQz>
}