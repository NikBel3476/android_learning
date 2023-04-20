package com.example.android_learning.domain.repo

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.android_learning.domain.relationship.TestQuestionCrossRef

data class TestWithQuestions(
    @Embedded val test: Test,
    @Relation(
        parentColumn = "testId",
        entityColumn = "questionId",
        associateBy = Junction(TestQuestionCrossRef::class)
    )
    val questions: List<Question>
)
