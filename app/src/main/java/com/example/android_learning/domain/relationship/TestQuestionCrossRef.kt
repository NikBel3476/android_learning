package com.example.android_learning.domain.relationship

import androidx.room.Entity

@Entity(primaryKeys = ["testId", "questionId"])
data class TestQuestionCrossRef(
    val testId: Long,
    val questionId: Long
)
