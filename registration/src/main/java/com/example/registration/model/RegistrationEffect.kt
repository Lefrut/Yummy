package com.example.registration.model;

import androidx.annotation.StringRes

sealed interface RegistrationEffect {
    data object NavigationToChats : RegistrationEffect


    data class ShowToast(@StringRes val resId: Int) : RegistrationEffect

}