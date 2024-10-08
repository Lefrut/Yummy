package com.example.chats;

import com.example.chats.model.ChatsEffect
import com.example.chats.model.ChatsState
import com.example.ui.viewmodel.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatsViewModel @Inject constructor() : MviViewModel<ChatsState, ChatsEffect>(ChatsState()) {
    fun navigateToChat(name: String) = intent {
        postSideEffect(ChatsEffect.NavigateToChat(name))
    }

    fun navigateToProfile() = intent {
        postSideEffect(ChatsEffect.NavigateToProfile)
    }

}