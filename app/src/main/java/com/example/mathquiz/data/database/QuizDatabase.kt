package com.example.mathquiz.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [QuizResult::class], version = 1, exportSchema = false)
abstract class QuizDatabase : RoomDatabase() {
    abstract fun quizDao(): QuizDao
}