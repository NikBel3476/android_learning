package com.example.android_learning.data.repositories

import com.example.android_learning.data.dao.QuestionDao
import com.example.android_learning.domain.repo.TestQuestion

class QuestionRepository(private val questionDao: QuestionDao) {
    suspend fun getAll() = questionDao.getAll()

    suspend fun getById(id: Long) = questionDao.getById(id)

    suspend fun getWithOptions(id: Long) = questionDao.getQuestionWithOptions(id)

    suspend fun getWithAnswers(id: Long) = questionDao.getQuestionWithAnswers(id)

    // FIXME: remove that mess(3 query to get similar question data)
    suspend fun getWithOptionsAndAnswers(id: Long): TestQuestion? {
        val question = questionDao.getById(id) ?: return null

        val questionWithOptions = questionDao.getQuestionWithOptions(id)
        val questionWithAnswers = questionDao.getQuestionWithAnswers(id)

        return TestQuestion(
            question,
            questionWithOptions.options,
            questionWithAnswers.answers
        )
    }
}