package com.alijan.newsapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alijan.newsapp.data.api.ApiClient
import com.alijan.newsapp.data.model.ArticleModel
import com.alijan.newsapp.data.repository.NewsRepository
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val newsRepository = NewsRepository()

    private var _newsList = MutableLiveData<List<ArticleModel>>()
    val newsList: LiveData<List<ArticleModel>> get() = _newsList

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    init {
        requestAllNews()
    }

    private fun requestAllNews(query: String = "Russia"){
        _isLoading.value = true
        viewModelScope.launch {
            val response = newsRepository.requestAllNews(query)

            if(response.isSuccessful){
                response.body()?.let {
                    _newsList.value = it.articles
                }
            }
            _isLoading.value = false
        }
    }
}