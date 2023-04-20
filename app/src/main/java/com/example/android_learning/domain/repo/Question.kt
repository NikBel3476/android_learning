package com.example.android_learning.domain.repo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Question(
    @PrimaryKey(autoGenerate = true) val questionId: Long,
    val text: String,
    val isRadio: Boolean
)
