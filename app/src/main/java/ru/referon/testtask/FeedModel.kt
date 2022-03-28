package ru.referon.testtask

import ru.referon.testtask.model.MainModel

data class FeedModel(
    val foods: MainModel? = null,
    val error: Boolean = false,
    val loading: Boolean = false
)
