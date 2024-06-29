package com.example.quizapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuizDao {

    @Query("DELETE FROM quiz")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(quiz: List<QuizEntity>)

    @Query("SELECT * FROM quiz")
    suspend fun getAll(): List<QuizEntity>
}