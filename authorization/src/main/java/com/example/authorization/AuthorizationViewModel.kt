package com.example.authorization

import com.example.authorization.model.AuthorizationEffect
import com.example.authorization.model.AuthorizationState
import com.example.ui.viewmodel.MviViewModel
import com.example.ui.viewmodel.reduceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.debounce
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor() :
    MviViewModel<AuthorizationState, AuthorizationEffect>(AuthorizationState()) {

    init {
        listenOpeations()
    }

    private val _operations = MutableSharedFlow<() -> Unit>(100)

    @OptIn(FlowPreview::class)
    fun listenOpeations() = intent {
        _operations.debounce(5).collect { block ->
            block()
        }
    }

    fun changePhoneNumber(newPhoneNumber: String) =
        intent {
            reduceState {
                copy(
                    phoneNumber = newPhoneNumber
                )
            }
        }
}