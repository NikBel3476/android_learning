package com.example.android_learning.domain.repo

import androidx.room.Embedded
import androidx.room.Relation

data class QuestionWithAnswers(
    @Embedded val question: Question,
    @Relation(
        parentColumn = "questionId",
        entityColumn = "questionId"
    )
    val answers: List<QuestionAnswer>
)
