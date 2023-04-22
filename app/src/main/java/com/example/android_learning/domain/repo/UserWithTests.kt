package com.example.android_learning.domain.repo

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.android_learning.domain.relationship.UserTestCrossRef

data class UserWithTests(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "testId",
        associateBy = Junction(UserTestCrossRef::class)
    )
    val tests: List<Test>
)
