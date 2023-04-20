package com.example.android_learning.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.android_learning.domain.repo.Test
import com.example.android_learning.domain.repo.TestWithQuestions
import kotlinx.coroutines.flow.Flow

@Dao
interface TestDao {
    @Query("SELECT * FROM test")
    fun getAll(): Flow<List<Test>>

    @Query("SELECT * FROM test WHERE testId=:id")
    suspend fun getById(id: Long): Test?

    @Transaction
    @Query("SELECT * FROM test WHERE testId=:id")
    fun getTestWithQuestions(id: Long): Flow<TestWithQuestions>

    @Insert
    suspend fun insert(test: Test): Long

    @Delete
    suspend fun delete(test: Test)
}