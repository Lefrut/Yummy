package com.example.data.service.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Detail(
    @SerialName("loc")
    val loc: List<String>,
    @SerialName("msg")
    val msg: String,
    @SerialName("type")
    val type: String
)