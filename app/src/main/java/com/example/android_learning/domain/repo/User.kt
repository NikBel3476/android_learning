package com.example.android_learning.domain.repo

import android.graphics.drawable.BitmapDrawable

data class User(
    val login: String,
    val password: String,
    val firstName: String,
    val nickname: String,
    val rating: Int,
    val drawable: BitmapDrawable?
)
