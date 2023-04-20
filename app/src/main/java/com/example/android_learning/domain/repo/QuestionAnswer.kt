package com.example.android_learning.domain.repo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuestionAnswer(
    @PrimaryKey(autoGenerate = true) val questionAnswerId: Long,
    val index: Int
)
