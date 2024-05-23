package com.alijan.newsapp.data.api

class ApiClient {
    companion object {
        fun createApi(): ApiService {
            return RetrofitClient.createRetrofit().create(ApiService::class.java)
        }
    }
}