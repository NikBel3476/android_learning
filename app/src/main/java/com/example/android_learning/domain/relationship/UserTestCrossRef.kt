package com.example.android_learning.domain.relationship

import androidx.room.Entity

@Entity(primaryKeys = ["userId", "testId"])
data class UserTestCrossRef(
    val userId: Long,
    val testId: Long
)