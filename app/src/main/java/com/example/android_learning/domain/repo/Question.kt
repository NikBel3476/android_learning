package com.example.android_learning.domain.repo

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [
        Index(name = "index_Question_text", value = ["text"], unique = true)
    ]
)
data class Question(
    @PrimaryKey(autoGenerate = true) val questionId: Long,
    val text: String,
    val isRadio: Boolean
)
