package ru.referon.testtask.repository

import ru.referon.testtask.model.MainModel

interface Repository {

    suspend fun getFoods(): MainModel
}