package com.example.android_learning.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.android_learning.domain.repo.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): Flow<List<User>>

    @Query("SELECT * FROM user WHERE uid=:uid")
    suspend fun findById(uid: Long): User?

    @Query("SELECT * FROM user WHERE login=:login")
    suspend fun findByLogin(login: String): User?

    @Insert
    suspend fun insertAll(user: User): Long

    @Delete
    suspend fun delete(user: User)
}