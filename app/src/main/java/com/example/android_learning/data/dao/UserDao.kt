package com.example.android_learning.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.android_learning.domain.repo.User
import com.example.android_learning.domain.repo.UserWithTests

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE userId=:id")
    suspend fun findById(id: Long): User?

    @Query("SELECT * FROM user WHERE login=:login")
    suspend fun findByLogin(login: String): User?

    @Transaction
    @Query("SELECT * FROM user WHERE userId=:id")
    suspend fun getUserWithTests(id: Long): UserWithTests

    @Insert
    suspend fun insert(user: User): Long

    @Delete
    suspend fun delete(user: User)
}