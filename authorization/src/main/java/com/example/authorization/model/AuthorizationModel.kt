package com.example.authorization.model

import androidx.annotation.StringRes

data class AuthorizationState(
    val phoneNumber: String = "",
    val authStage: AuthorizationStage = AuthorizationStage.Phone
)

enum class AuthorizationStage {
    Phone,
    Code
}

sealed class AuthorizationEffect {

    data class ShowToast(@StringRes val resId: Int) : AuthorizationEffect()


}