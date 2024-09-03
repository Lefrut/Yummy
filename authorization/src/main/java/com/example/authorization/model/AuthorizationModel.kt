package com.example.authorization.model

data class AuthorizationState(
    val phoneNumber: String = ""
)

sealed class AuthorizationEffect {


}