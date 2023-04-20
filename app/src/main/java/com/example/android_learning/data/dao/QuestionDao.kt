package com.example.android_learning.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.android_learning.domain.repo.Question
import com.example.android_learning.domain.repo.QuestionWithOptions
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDao {
    @Query("SELECT * FROM question")
    fun getAll(): Flow<List<Question>>

    @Query("SELECT * FROM question WHERE questionId=:id")
    suspend fun getById(id: Long): Question?

    @Transaction
    @Query("SELECT * FROM question WHERE questionId=:id")
    fun getQuestionWithOptions(id: Long): Flow<List<QuestionWithOptions>>

    @Insert
    suspend fun insert(question: Question): Long

    @Delete
    suspend fun delete(question: Question)
}
