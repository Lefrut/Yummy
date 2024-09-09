package com.example.registration;

import com.example.domain.usecase.UserInteractor
import com.example.registration.model.RegistrationEffect
import com.example.registration.model.RegistrationState
import com.example.resources.R
import com.example.ui.viewmodel.MviViewModel
import com.example.ui.viewmodel.reduceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val userInteractor: UserInteractor
) :
    MviViewModel<RegistrationState, RegistrationEffect>(RegistrationState()) {

    fun changeName(newName: String) = intent {
        if (!isValidName(newName)) return@intent
        reduceState {
            copy(name = newName)
        }
    }

    fun changeUsername(newUsername: String) = intent {
        if (!isValidUsername(newUsername)) return@intent
        reduceState {
            copy(username = newUsername)
        }
    }

    private val registerMutex = Mutex()

    fun register() = intent {
        if (state.name.isBlank() || state.username.isBlank()) run {
            postSideEffect(RegistrationEffect.ShowToast(R.string.incorrect_name_or_username))
            return@intent
        }

        registerMutex.withLock {
            val registerResult =
                with(state) {
                    withContext(Dispatchers.IO) {
                        userInteractor.register(
                            phoneNumber,
                            name,
                            username
                        )
                    }
                }

            registerResult.onSuccess {
                postSideEffect(RegistrationEffect.NavigationToChats)
            }.onFailure {
                postSideEffect(RegistrationEffect.ShowToast(R.string.failed_register))
            }
            delay(200L)
        }
    }

    private fun isValidUsername(username: String): Boolean {
        val regex = "^[a-zA-Z0-9._-]{0,25}\$".toRegex()
        return regex.matches(username)
    }

    private fun isValidName(name: String): Boolean {
        val regex = "^[а-яА-Я]{0,22}\$".toRegex()
        return regex.matches(name)
    }


}