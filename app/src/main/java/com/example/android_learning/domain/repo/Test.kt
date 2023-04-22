package com.example.android_learning.domain.repo

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [
        Index(name = "index_Test_name", value = ["name"], unique = true)
    ]
)
data class Test(
    @PrimaryKey(autoGenerate = true) val testId: Long,
    val name: String,
) {
    constructor(name: String) : this(
        testId = 0,
        name = name
    )
}
