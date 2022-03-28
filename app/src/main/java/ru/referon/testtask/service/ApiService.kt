package ru.referon.testtask

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import ru.referon.testtask.model.MainModel

private val BASE_URL = "https://api.spoonacular.com/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("recipes/complexSearch?apiKey=95fb966dc92346f5a05f09cdff8c6378&query=pizza&addRecipeInformation=true")
    suspend fun getFoods(): MainModel

}
object PostsApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}