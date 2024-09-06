package com.example.data.service.model


import androidx.annotation.Keep
import com.example.domain.entity.AuthUser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class AuthToken(
    @SerialName("access_token")
    val accessToken: String?,
    @SerialName("is_user_exists")
    val isUserExists: Boolean?,
    @SerialName("refresh_token")
    val refreshToken: String?,
    @SerialName("user_id")
    val userId: Int?
)

fun AuthToken.toAuthUser(): AuthUser {
    return AuthUser(
        token = accessToken ?: "",
        refreshToken = refreshToken ?: "",
        userId = userId ?: 0,
        haveUser = isUserExists ?: false
    )
}