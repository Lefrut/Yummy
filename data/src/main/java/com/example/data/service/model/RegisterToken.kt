package com.example.data.service.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep
import com.example.domain.entity.RegisterUser

@Keep
@Serializable
data class RegisterToken(
    @SerialName("access_token")
    val accessToken: String?,
    @SerialName("refresh_token")
    val refreshToken: String?,
    @SerialName("user_id")
    val userId: Int?
)

fun RegisterToken.toRegisterUser() = RegisterUser(
    accessToken!!, refreshToken!!, userId!!
)