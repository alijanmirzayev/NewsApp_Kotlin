package com.alijan.newsapp.data.datasource

import com.alijan.newsapp.data.api.ApiClient
import com.alijan.newsapp.data.model.NewsResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class NewsDataSource {
    private val api = ApiClient.createApi()

    suspend fun requestAllNews(query: String): Response<NewsResponseModel> =
        withContext(Dispatchers.IO){
            val response = api.getAllNews(query)
            return@withContext response
        }
}