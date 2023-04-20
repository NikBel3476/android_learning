package com.example.android_learning.data

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android_learning.data.dao.QuestionDao
import com.example.android_learning.data.dao.TestDao
import com.example.android_learning.data.dao.UserDao
import com.example.android_learning.domain.relationship.TestQuestionCrossRef
import com.example.android_learning.domain.relationship.UserTestCrossRef
import com.example.android_learning.domain.repo.Question
import com.example.android_learning.domain.repo.QuestionAnswer
import com.example.android_learning.domain.repo.QuestionOption
import com.example.android_learning.domain.repo.Test
import com.example.android_learning.domain.repo.User

//@Database(entities = [User::class], version = 1)
//abstract class AppDatabase : RoomDatabase() {
//    abstract val userDao: UserDao
//}

//@Database(
//    version = 2,
//    entities = [User::class],
//    autoMigrations = [
//        AutoMigration (from = 1, to = 2)
//    ]
//)
//abstract class AppDatabase : RoomDatabase() {
//    abstract val userDao: UserDao
//}

@Database(
    version = 3,
    entities = [
        User::class,
        Test::class,
        Question::class,
        QuestionOption::class,
        QuestionAnswer::class,
        UserTestCrossRef::class,
        TestQuestionCrossRef::class
    ],
    autoMigrations = [
        AutoMigration (from = 2, to = 3)
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val testDao: TestDao
    abstract val questionDao: QuestionDao
}