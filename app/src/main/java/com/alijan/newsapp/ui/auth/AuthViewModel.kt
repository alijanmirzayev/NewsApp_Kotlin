package com.alijan.newsapp.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val auth = FirebaseAuth.getInstance()

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private var _isLogin = MutableLiveData<Boolean>()
    val isLogin: LiveData<Boolean> get() = _isLogin

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun requestSignIn(email: String, password: String) {
        _isLoading.value = true
        viewModelScope.launch {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                _isLogin.value = it.isSuccessful

                if (!it.isSuccessful) {
                    _errorMessage.value = it.exception?.localizedMessage
                }

                _isLoading.value = false
            }
        }
    }

    fun requestSignUp(email: String, password: String) {
        _isLoading.value = true
        viewModelScope.launch {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                _isLogin.value = it.isSuccessful

                if (!it.isSuccessful) {
                    _errorMessage.value = it.exception?.localizedMessage
                }
                _isLoading.value = false
            }
        }
    }

}