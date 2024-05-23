package com.alijan.newsapp.data.datasource

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthDataSource {

    private val auth = FirebaseAuth.getInstance()

    suspend fun requestSignIn(email: String, password: String) =
        withContext(Dispatchers.IO){
            val response = auth.signInWithEmailAndPassword(email, password)
            return@withContext response
        }

    suspend fun requestSignUp(email: String, password: String) =
        withContext(Dispatchers.IO){
            val response = auth.createUserWithEmailAndPassword(email, password)
            return@withContext response
        }
}