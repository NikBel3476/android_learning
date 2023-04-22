package com.example.android_learning.domain.repo

data class TestQuestion(
    val question: Question,
    val options: List<QuestionOption>,
    val answers: List<QuestionAnswer>
)
