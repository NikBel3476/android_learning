package com.example.android_learning.domain.repo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuestionOption(
    @PrimaryKey(autoGenerate = true) val questionOptionId: Long,
    val questionId: Long,
    val text: String
)
