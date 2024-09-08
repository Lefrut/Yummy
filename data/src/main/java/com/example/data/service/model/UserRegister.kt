package com.example.data.service.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class UserRegister(
    @SerialName("name")
    val name: String?,
    @SerialName("phone")
    val phone: String?,
    @SerialName("username")
    val username: String?
)