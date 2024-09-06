package com.example.registration;

import com.example.registration.model.RegistrationEffect
import com.example.registration.model.RegistrationState
import com.example.ui.viewmodel.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor() :
    MviViewModel<RegistrationState, RegistrationEffect>(RegistrationState()) {

}