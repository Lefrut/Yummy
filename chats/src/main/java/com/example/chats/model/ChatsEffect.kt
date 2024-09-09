package com.example.chats.model;

sealed interface ChatsEffect {

    class NavigateToChat(val name: String) : ChatsEffect

}