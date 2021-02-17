package com.fowels.tagpayncto.data.responses

data class LoginResponse(
    val bvn: String?,
    val createdAt: String,
    val email: String,
    val expiresIn: Long,
    val firstName: String,
    val lastLoggedIn: String,
    val lastName: String,
    val level: String,
    val mobileNumber: String,
    val permissions: List<String>,
    val phoneNumber: String,
    val projectUuid: String,
    val roles: List<String>,
    val token: String,
    val uuid: String
)