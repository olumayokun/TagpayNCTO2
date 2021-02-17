package com.fowels.tagpayncto.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fowels.tagpayncto.data.network.Resource
import com.fowels.tagpayncto.data.repositories.AuthRepository
import com.fowels.tagpayncto.data.responses.LoginResponse
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>> get() = _loginResponse


    fun login(
        email: String,
        password: String,
        imei: String,
        model: String,
        rememberMe: Boolean
    ) = viewModelScope.launch {
        _loginResponse.value = repository.login(email, password, imei, model, rememberMe)
    }

    fun register(
        code: String,
        emailOrPhone: String,
        imei: String,
        model: String,
        password: String,
        pin: String,
        rememberMe: Boolean
    ) = viewModelScope.launch {
        _loginResponse.value = repository.register(code, emailOrPhone, imei, model, password, pin, rememberMe)
    }
}