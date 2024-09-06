package com.example.data.service.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class UserProfile(
    @SerialName("profile_data")
    val profileData: ProfileData?
)