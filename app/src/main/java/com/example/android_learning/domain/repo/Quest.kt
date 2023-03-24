package com.example.android_learning.domain.repo

data class Quest(
    val text: String,
    val isRadio: Boolean,
    val option: List<String>,
    val correctIndex: List<Int>
)
