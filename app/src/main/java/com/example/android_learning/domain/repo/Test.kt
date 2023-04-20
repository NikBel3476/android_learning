package com.example.android_learning.domain.repo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Test(
    @PrimaryKey(autoGenerate = true) val testId: Long,
    val name: String,
    var rating: Int
) {
    constructor(name: String) : this(
        testId = 0,
        name = name,
        rating = 0
    )
}
