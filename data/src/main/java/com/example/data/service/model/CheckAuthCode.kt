package com.example.data.service.model

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class CheckAuthCode(
    val phone: String,
    val code: String
)
