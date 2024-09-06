package com.example.data.service.model

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Keep
@Serializable
data class Phone(
    @SerialName("phone")
    val phone: String
)
