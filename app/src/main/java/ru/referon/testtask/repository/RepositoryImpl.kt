package ru.referon.testtask.repository

import ru.referon.testtask.PostsApi
import ru.referon.testtask.model.MainModel

class RepositoryImpl: Repository {

    override suspend fun getFoods(): MainModel = PostsApi.retrofitService.getFoods()
}