package com.example.data.service.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Avatars(
    @SerialName("avatar")
    val avatar: String?,
    @SerialName("bigAvatar")
    val bigAvatar: String?,
    @SerialName("miniAvatar")
    val miniAvatar: String?
)