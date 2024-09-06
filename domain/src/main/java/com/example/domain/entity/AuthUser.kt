package com.example.domain.entity


data class AuthUser(
    val token: String,
    val refreshToken: String,
    val userId: Int,
    val haveUser: Boolean
)
