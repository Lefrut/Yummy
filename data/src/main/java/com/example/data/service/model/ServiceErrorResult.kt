package com.example.data.service.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class ServiceErrorResult(
    @SerialName("detail")
    val detail: List<Detail>
)