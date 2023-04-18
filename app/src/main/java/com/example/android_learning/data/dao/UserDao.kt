package com.example.android_learning.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.android_learning.domain.repo.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>

    @Query("SELECT * FROM user WHERE uid=:uid")
    fun findById(uid: Long): User?

    @Query("SELECT * FROM user WHERE login=:login")
    fun findByLogin(login: String): User?

    @Insert
    fun insertAll(user: User): Long

    @Delete
    fun delete(user: User)
}