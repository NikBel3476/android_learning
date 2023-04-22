package com.example.android_learning.domain.repo

import android.graphics.drawable.BitmapDrawable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [
        Index(name = "index_User_login", value = ["login"], unique = true)
    ]
)
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Long,
    val login: String,
    val password: String,
) {
    @Ignore
    val firstName: String? = null

    @Ignore
    val nickname: String? = null

    @Ignore
    val rating: Int? = null

    @Ignore
    val drawable: BitmapDrawable? = null
}
