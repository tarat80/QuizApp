package com.example.quizapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [QuizEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class QuizDataBase : RoomDatabase() {
    abstract fun quizDao(): QuizDao
}