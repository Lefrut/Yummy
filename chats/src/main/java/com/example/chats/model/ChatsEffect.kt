package com.example.chats.model;

sealed interface ChatsEffect {
    data object NavigateToProfile : ChatsEffect

    class NavigateToChat(val name: String) : ChatsEffect

}