package com.example.authorization

import com.example.ui.viewmodel.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor() :
    MviViewModel<AuthorizationState, AuthorizationEffect>(AuthorizationState()) {


}