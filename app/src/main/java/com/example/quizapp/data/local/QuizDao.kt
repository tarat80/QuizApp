package com.example.quizapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizDao {

    @Query("DELETE FROM quiz")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quiz: List<QuizEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(quiz: QuizEntity)

    @Query("SELECT * FROM quiz")
    fun getAll(): Flow<List<QuizEntity>>
}