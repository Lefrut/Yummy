package com.example.data.service.model


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class SendPhoneResult(
    @SerialName("is_success")
    val isSuccess: Boolean
)