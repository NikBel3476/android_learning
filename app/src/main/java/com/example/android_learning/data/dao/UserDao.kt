package com.example.android_learning.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.android_learning.domain.repo.User
import com.example.android_learning.domain.repo.UserWithTests
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): Flow<List<User>>

    @Query("SELECT * FROM user WHERE userId=:id")
    suspend fun findById(id: Long): User?

    @Query("SELECT * FROM user WHERE login=:login")
    suspend fun findByLogin(login: String): User?

    @Transaction
    @Query("SELECT * FROM user WHERE userId=:id")
    fun getUserWithTests(id: Long): Flow<List<UserWithTests>>

    @Insert
    suspend fun insert(user: User): Long

    @Delete
    suspend fun delete(user: User)
}