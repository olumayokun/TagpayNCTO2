package com.fowels.tagpayncto.data.network

import com.fowels.tagpayncto.data.responses.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("auth/social")
    suspend fun login(
        @Field("emailOrPhone") emailOrPhone: String,
        @Field("password") password: String,
        @Field("imei") imei: String,
        @Field("model") model: String,
        @Field("rememberMe") rememberMe: Boolean
    ) : LoginResponse

    @FormUrlEncoded
    @POST("auth/register-device")
    suspend fun register(
        @Field("code") code: String,
        @Field("emailOrPhone") emailOrPhone: String,
        @Field("imei") imei: String,
        @Field("model") model: String,
        @Field("password") password: String,
        @Field("pin") pin: String,
        @Field("rememberMe") rememberMe: Boolean
    ) : LoginResponse
}
