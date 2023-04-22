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
    suspend fun getAll(): List<Test>

    @Query("SELECT * FROM test WHERE testId=:id")
    suspend fun getById(id: Long): Test?

    @Transaction
    @Query("SELECT * FROM test WHERE testId=:id")
    suspend fun getTestWithQuestions(id: Long): TestWithQuestions

    @Transaction
    @Query("SELECT t.testId, t.name from UserTestCrossRef ut " +
            "JOIN test t ON ut.testId = t.testId " +
            "WHERE ut.userId = :userId")
    suspend fun getUserTests(userId: Long): List<Test>

    @Insert
    suspend fun insert(test: Test): Long

    @Delete
    suspend fun delete(test: Test)
}