package com.alijan.newsapp.data.repository

import com.alijan.newsapp.data.datasource.NewsDataSource

class NewsRepository {
    private val newsDataSource = NewsDataSource()

    suspend fun requestAllNews(query: String) = newsDataSource.requestAllNews(query)
}