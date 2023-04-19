package com.example.android_learning.data

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android_learning.data.dao.UserDao
import com.example.android_learning.domain.repo.User

//@Database(entities = [User::class], version = 1)
//abstract class AppDatabase : RoomDatabase() {
//    abstract val userDao: UserDao
//}

// Database class after the version update.
@Database(
    version = 2,
    entities = [User::class],
    autoMigrations = [
        AutoMigration (from = 1, to = 2)
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao
}