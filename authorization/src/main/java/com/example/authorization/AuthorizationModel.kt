package com.example.authorization

data class AuthorizationState(
    val phoneNumber: String = ""
)

sealed class AuthorizationEffect {


}