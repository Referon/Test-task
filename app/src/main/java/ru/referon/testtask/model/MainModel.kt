package ru.referon.testtask.model

data class MainModel(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)