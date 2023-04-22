package com.example.android_learning.data

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.android_learning.data.dao.QuestionDao
import com.example.android_learning.data.dao.TestDao
import com.example.android_learning.data.dao.UserDao
import com.example.android_learning.domain.relationship.TestQuestionCrossRef
import com.example.android_learning.domain.relationship.UserTestCrossRef
import com.example.android_learning.domain.repo.Question
import com.example.android_learning.domain.repo.QuestionAnswer
import com.example.android_learning.domain.repo.QuestionOption
import com.example.android_learning.domain.repo.Source
import com.example.android_learning.domain.repo.Test
import com.example.android_learning.domain.repo.User
import com.example.android_learning.utils.DATABASE_NAME
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors

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

//@Database(
//    version = 3,
//    entities = [
//        User::class,
//        Test::class,
//        Question::class,
//        QuestionOption::class,
//        QuestionAnswer::class,
//        UserTestCrossRef::class,
//        TestQuestionCrossRef::class
//    ],
//    autoMigrations = [
//        AutoMigration (
//            from = 2,
//            to = 3,
//            spec = AppDatabase.AutoMigration::class
//        )
//    ]
//)
//abstract class AppDatabase : RoomDatabase() {
//    abstract val userDao: UserDao
//    abstract val testDao: TestDao
//    abstract val questionDao: QuestionDao
//
//    @RenameColumn(tableName = "User", fromColumnName = "uid", toColumnName = "userId")
//    class AutoMigration : AutoMigrationSpec
//
//    companion object {
//        private var instance: AppDatabase? = null
//
//        fun getInstance(context: Context) : AppDatabase =
//            instance ?: synchronized(this) {
//                instance ?: buildDatabase(context).also { instance = it }
//            }
//
//        private fun buildDatabase(context: Context) =
//            Room.databaseBuilder(
//                context,
//                AppDatabase::class.java,
//                DATABASE_NAME
//            )
////            .addCallback(seedDatabaseCallback(context))
//            .build()
//
//        private fun seedDatabaseCallback(context: Context): Callback {
//            return object : Callback() {
//                override fun onCreate(db: SupportSQLiteDatabase) {
//                    super.onCreate(db)
//                    Executors.newSingleThreadExecutor().execute {
//                        val instance = getInstance(context)
//
//                        runBlocking {
//                            Source.generateUsers().map {
//                                async {
//                                    instance.userDao.insert(it)
//                                }
//                            }.map {
//                                it.await()
//                            }
//
//                            Source.generateTests().map {
//                                async {
//                                    instance.testDao.insert(it)
//                                }
//                            }.map {
//                                it.await()
//                            }
//
//
//
//                            Source.generateQuestions().map {
//                                async {
//                                    instance.questionDao.insert(it)
//                                }
//                            }.map {
//                                it.await()
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//}

//val MIGRATION_3_4 = object : Migration(3, 4) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_User_login ON User (login)")
//        database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_Test_name ON Test (name)")
//        database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_Question_text ON Question (text)")
//    }
//}

//@Database(
//    version = 4,
//    entities = [
//        User::class,
//        Test::class,
//        Question::class,
//        QuestionOption::class,
//        QuestionAnswer::class,
//        UserTestCrossRef::class,
//        TestQuestionCrossRef::class
//    ],
//    autoMigrations = [
//        AutoMigration (from = 3, to = 4)
//    ]
//)
//abstract class AppDatabase : RoomDatabase() {
//    abstract val userDao: UserDao
//    abstract val testDao: TestDao
//    abstract val questionDao: QuestionDao
//
//    companion object {
//        private var instance: AppDatabase? = null
//
//        fun getInstance(context: Context) : AppDatabase =
//            instance ?: synchronized(this) {
//                instance ?: buildDatabase(context).also { instance = it }
//            }
//
//        private fun buildDatabase(context: Context) =
//            Room.databaseBuilder(
//                context,
//                AppDatabase::class.java,
//                DATABASE_NAME
//            )
//            .addMigrations(MIGRATION_3_4)
//            .build()
//    }
//}

@Database(
    version = 5,
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
        AutoMigration (
            from = 4,
            to = 5,
            spec = AppDatabase.AutoMigration::class
        )
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val testDao: TestDao
    abstract val questionDao: QuestionDao

    class AutoMigration : AutoMigrationSpec

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                DATABASE_NAME
            ).build()
    }
}
