package com.alijan.newsapp.data.model


import com.google.gson.annotations.SerializedName

data class NewsResponseModel(
    @SerializedName("articles")
    val articles: List<ArticleModel>,
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Int?
)