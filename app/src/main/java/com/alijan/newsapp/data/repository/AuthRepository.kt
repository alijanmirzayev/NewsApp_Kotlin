package com.alijan.newsapp.data.repository

import com.alijan.newsapp.data.datasource.AuthDataSource

class AuthRepository {

    private val authDataSource = AuthDataSource()

    suspend fun requestSignIn(email: String, password: String) = authDataSource.requestSignIn(email, password)
    suspend fun requestSignUp(email: String, password: String) = authDataSource.requestSignUp(email, password)
}