package com.example.chat;

import androidx.lifecycle.SavedStateHandle
import com.example.chat.model.ChatEffect
import com.example.chat.model.ChatState
import com.example.navigation.NavScreen
import com.example.ui.viewmodel.MviViewModel
import com.example.ui.viewmodel.reduceState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : MviViewModel<ChatState, ChatEffect>(ChatState()) {

    init {
        val name = savedStateHandle.get<String>(NavScreen.Chat.NAME) ?: ""
        intent { reduceState { copy(name = name) } }
    }

}