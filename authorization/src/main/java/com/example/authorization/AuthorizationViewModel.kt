package com.example.authorization

import com.example.authorization.model.AuthorizationEffect
import com.example.authorization.model.AuthorizationStage
import com.example.authorization.model.AuthorizationState
import com.example.domain.usecase.UserInteractor
import com.example.resources.R
import com.example.ui.viewmodel.MviViewModel
import com.example.ui.viewmodel.reduceState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val userInteractor: UserInteractor
) : MviViewModel<AuthorizationState, AuthorizationEffect>(AuthorizationState()) {


    fun changePhoneNumber(newPhoneNumber: String) =
        intent {
            reduceState {
                copy(
                    phoneNumber = newPhoneNumber
                )
            }
        }

    fun requestAuthCode(countryCode: String) = intent {
        val fullNumber = countryCode + state.phoneNumber
        userInteractor.sendAuthCode(fullNumber).onSuccess {
            if (it.isSent) reduceState { copy(authStage = AuthorizationStage.Code) }
            else postSideEffect(AuthorizationEffect.ShowToast(R.string.failed_send_code))
        }.onFailure {
            println(it.localizedMessage?.toString())
            postSideEffect(AuthorizationEffect.ShowToast(R.string.incorrect_phone_nubmer))
        }
    }

    fun changeCode(newCode: String) = intent {
        reduceState {
            copy(
                code = newCode
            )
        }
        if (newCode.length == 6 && newCode == "133337") {
            postSideEffect(AuthorizationEffect.NavigateToRegistration)
        }
    }
}