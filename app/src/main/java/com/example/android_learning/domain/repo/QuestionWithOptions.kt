package com.example.android_learning.domain.repo

import androidx.room.Embedded
import androidx.room.Relation

data class QuestionWithOptions(
    @Embedded val question: Question,
    @Relation(
        parentColumn = "questionId",
        entityColumn = "questionId"
    )
    val options: List<QuestionOption>
)
