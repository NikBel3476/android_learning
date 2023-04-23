package com.example.android_learning.domain.repo

import com.example.android_learning.domain.relationship.TestQuestionCrossRef
import com.example.android_learning.domain.relationship.UserTestCrossRef

object Source {
    fun generateUsers() = mutableListOf(
        User(userId = 1, login = "abc", password = "abc"),
        User(userId = 2, login = "user", password = "user")
    )

    fun generateTests() = mutableListOf(
        Test(testId = 1, name = "Тест по информатике"),
        Test(testId = 2, name = "Математический тест")
    )

    fun generateUserTest() = mutableListOf(
        UserTestCrossRef(userId = 1, testId = 1),
        UserTestCrossRef(userId = 1, testId = 2),
        UserTestCrossRef(userId = 2, testId = 1),
        UserTestCrossRef(userId = 2, testId = 2)
    )

    fun generateQuestions() = mutableListOf(
        Question(questionId = 1, isRadio = true, text = "Сколько байт занимает число одинарной точности?"),
        Question(questionId = 2, isRadio = true, text = "Чему равна мощность алфавита <abcd>?"),
        Question(questionId = 3, isRadio = true, text = "Сколько байт занимает число двойной точности?"),
        Question(questionId = 4, isRadio = true, text = "Сколько мегабайт в одном гигабайте?"),
        Question(questionId = 5, isRadio = true, text = "Сколько бит в байте?"),
        Question(questionId = 6, isRadio = true, text = "2 + 2"),
        Question(questionId = 7, isRadio = true, text = "5 - 2"),
        Question(questionId = 8, isRadio = true, text = "3 * 4"),
        Question(questionId = 9, isRadio = true, text = "12 / 4"),
        Question(questionId = 10, isRadio = true, text = "10 + 3")
    )

    fun generateTestQuestion() = mutableListOf(
        TestQuestionCrossRef(testId = 1, questionId = 1),
        TestQuestionCrossRef(testId = 1, questionId = 2),
        TestQuestionCrossRef(testId = 1, questionId = 3),
        TestQuestionCrossRef(testId = 1, questionId = 4),
        TestQuestionCrossRef(testId = 1, questionId = 5),
        TestQuestionCrossRef(testId = 2, questionId = 6),
        TestQuestionCrossRef(testId = 2, questionId = 7),
        TestQuestionCrossRef(testId = 2, questionId = 8),
        TestQuestionCrossRef(testId = 2, questionId = 9),
        TestQuestionCrossRef(testId = 2, questionId = 10)
    )

    fun generateQuestionOption() = mutableListOf(
        QuestionOption(1, 1, "1"),
        QuestionOption(2, 1, "2"),
        QuestionOption(3, 1, "4"),
        QuestionOption(4, 1, "8"),
        QuestionOption(5, 2, "2"),
        QuestionOption(6, 2, "4"),
        QuestionOption(7, 2, "8"),
        QuestionOption(8, 2, "16"),
        QuestionOption(9, 3, "1"),
        QuestionOption(10, 3, "2"),
        QuestionOption(11, 3, "4"),
        QuestionOption(12, 3, "8"),
        QuestionOption(13, 4, "8"),
        QuestionOption(14, 4, "64"),
        QuestionOption(15, 4, "1000"),
        QuestionOption(16, 4, "1024"),
        QuestionOption(17, 5, "2"),
        QuestionOption(18, 5, "8"),
        QuestionOption(19, 5, "16"),
        QuestionOption(20, 5, "1024"),
        QuestionOption(21, 6, "3"),
        QuestionOption(22, 6, "4"),
        QuestionOption(23, 6, "5"),
        QuestionOption(24, 6, "6"),
        QuestionOption(25, 7, "1"),
        QuestionOption(26, 7, "2"),
        QuestionOption(27, 7, "3"),
        QuestionOption(28, 7, "4"),
        QuestionOption(29, 8, "8"),
        QuestionOption(30, 8, "12"),
        QuestionOption(31, 8, "16"),
        QuestionOption(32, 8, "20"),
        QuestionOption(33, 9, "1"),
        QuestionOption(34, 9, "2"),
        QuestionOption(35, 9, "3"),
        QuestionOption(36, 9, "4"),
        QuestionOption(37, 10, "10"),
        QuestionOption(38, 10, "11"),
        QuestionOption(39, 10, "12"),
        QuestionOption(40, 10, "13")
    )

    fun generateQuestionAnswer() = mutableListOf(
        QuestionAnswer(1, 1, 3),
        QuestionAnswer(2, 2, 2),
        QuestionAnswer(3, 3, 4),
        QuestionAnswer(4, 4, 4),
        QuestionAnswer(5, 5, 2),
        QuestionAnswer(6, 6, 2),
        QuestionAnswer(7, 7, 3),
        QuestionAnswer(8, 8, 2),
        QuestionAnswer(9, 9, 3),
        QuestionAnswer(10, 10, 4),
    )

    /*result.questions.add(
        Question(
            questionId = 0,
            text = "Вопрос",
            isRadio = true,
            option = mutableListOf("1. option", "2. option", "3. option", "4. option"),
            correctIndex = mutableListOf(1)
        )
    )*/

    /*fun generateUserDataView(): UserDataView {
        return UserDataView(
            firstName = "FIRST_NAME",
            nickname = "NICK_NAME",
            rating = 3.5F,
            drawable = null
        )
    }*/
}