package com.example.domain.entity

data class RegisterUser(
    val accessToken: String,
    val refreshToken: String,
    val userId: Int
)
