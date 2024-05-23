package com.alijan.newsapp.ui.home

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alijan.newsapp.data.api.ApiClient
import com.alijan.newsapp.data.model.ArticleModel
import com.alijan.newsapp.data.model.NewsResponseModel
import com.alijan.newsapp.data.repository.NewsRepository
import com.alijan.newsapp.util.toastError
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            try {
                val response = newsRepository.requestAllNews(query)

                if(response.isSuccessful){
                    response.body()?.let {
                        _newsList.value = it.articles
                    }
                }
            } catch (e: Exception){
                _errorMessage.value = e.localizedMessage.toString()
            } finally {
                _isLoading.value = false
            }

        }
    }
}