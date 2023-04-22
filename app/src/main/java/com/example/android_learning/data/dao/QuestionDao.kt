package com.example.android_learning.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.android_learning.domain.repo.Question
import com.example.android_learning.domain.repo.QuestionWithAnswers
import com.example.android_learning.domain.repo.QuestionWithOptions

@Dao
interface QuestionDao {
    @Query("SELECT * FROM question")
    suspend fun getAll(): List<Question>

    @Query("SELECT * FROM question WHERE questionId=:id")
    suspend fun getById(id: Long): Question?

    @Transaction
    @Query("SELECT * FROM question WHERE questionId=:id")
    suspend fun getQuestionWithOptions(id: Long): QuestionWithOptions

    @Transaction
    @Query("SELECT * FROM question WHERE questionId=:id")
    suspend fun getQuestionWithAnswers(id: Long): QuestionWithAnswers

    @Insert
    suspend fun insert(question: Question): Long

    @Delete
    suspend fun delete(question: Question)
}
