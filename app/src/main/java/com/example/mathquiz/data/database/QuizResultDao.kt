package com.example.mathquiz.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizResultDao {
    @Insert
    suspend fun insertQuizResult(quizResult: QuizResult)

    @Query("SELECT * FROM quiz_results ORDER BY date DESC")
    fun getAllQuizResults(): Flow<List<QuizResult>>
}