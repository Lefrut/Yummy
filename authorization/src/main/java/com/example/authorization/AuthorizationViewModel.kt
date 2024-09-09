package com.example.authorization

import com.example.authorization.model.AuthorizationEffect
import com.example.authorization.model.AuthorizationStage
import com.example.authorization.model.AuthorizationState
import com.example.domain.usecase.UserInteractor
import com.example.resources.R
import com.example.ui.viewmodel.MviViewModel
import com.example.ui.viewmodel.reduceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val userInteractor: UserInteractor
) : MviViewModel<AuthorizationState, AuthorizationEffect>(AuthorizationState()) {


    private val changePhoneMutex = Mutex()

    fun changePhoneNumber(newPhoneNumber: String) = intent {
        changePhoneMutex.withLock {
            reduceState {
                copy(
                    phoneNumber = newPhoneNumber
                )
            }
        }
    }

    fun requestAuthCode(countryCode: String) = intent {
        val fullNumber = countryCode + state.phoneNumber
        userInteractor.sendAuthCode(fullNumber).onSuccess {
            if (it.isSent) reduceState {
                copy(
                    authStage = AuthorizationStage.Code,
                    phoneNumber = fullNumber
                )
            }
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
        if (newCode.length != 6) return@intent

        val user = userInteractor.login(state.phoneNumber, newCode).getOrNull() ?: run {
            postSideEffect(AuthorizationEffect.ShowToast(R.string.incorrect_code))
            reduceState {
                copy(
                    code = ""
                )
            }
            return@intent
        }

        if (user.haveUser) {
            postSideEffect(AuthorizationEffect.NavigateToChats)
        } else {
            postSideEffect(AuthorizationEffect.NavigateToRegistration)
        }

    }
}