package com.alijan.newsapp.data.api

import com.alijan.newsapp.util.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        fun createRetrofit(): Retrofit {
            return Retrofit
                .Builder()
                .baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}