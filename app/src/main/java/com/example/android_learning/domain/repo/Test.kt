package com.example.android_learning.domain.repo

data class Test(
    val name: String,
    var isPassed: Boolean,
    var second: Int,
    var rating: Int,
    var quest: ArrayList<Quest>
) {
    constructor(name: String) : this(
        name = name,
        isPassed = false,
        second = 0,
        rating = 0,
        quest = ArrayList()
    )
}
