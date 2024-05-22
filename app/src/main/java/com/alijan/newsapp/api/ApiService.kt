package com.alijan.newsapp.api

import com.alijan.newsapp.model.NewsResponseModel
import com.alijan.newsapp.util.Constant
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/everything")
    suspend fun getAllNews(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String = Constant.API_KEY): Response<NewsResponseModel>
}