package com.example.profile;

import com.example.domain.usecase.UserInteractor
import com.example.profile.model.ProfileEffect
import com.example.profile.model.ProfileState
import com.example.ui.viewmodel.MviViewModel
import com.example.ui.viewmodel.reduceState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userInteractor: UserInteractor
) :
    MviViewModel<ProfileState, ProfileEffect>(ProfileState()) {

    init {
        requestUserName()
    }

    private fun requestUserName() = intent {
        userInteractor.getUserName().onSuccess {
            reduceState {
                copy(username = it)
            }
        }.onFailure {
            reduceState {
                copy(username = "Error loading name")
            }
        }

    }

}