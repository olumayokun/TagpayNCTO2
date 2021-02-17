package com.fowels.tagpayncto.data.repositories

import com.fowels.tagpayncto.data.network.AuthApi

class AuthRepository(
    private val api: AuthApi
) : BaseRepository() {

    suspend fun login(
        email: String,
        password: String,
        imei: String,
        model: String,
        rememberMe: Boolean
    ) = safeApiCall {
        api.login(email, password, imei, model, rememberMe)
    }

    suspend fun register(
        code: String,
        emailOrPhone: String,
        imei: String,
        model: String,
        password: String,
        pin: String,
        rememberMe: Boolean
    ) = safeApiCall {
        api.register(code, emailOrPhone, imei, model, password, pin, rememberMe)
    }
}