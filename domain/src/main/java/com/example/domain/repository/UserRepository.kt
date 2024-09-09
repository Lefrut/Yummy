package com.example.domain.repository

import com.example.domain.entity.AuthUser
import com.example.domain.entity.CodeStatus
import com.example.domain.entity.RegisterUser

interface UserRepository {

    suspend fun register(phone: String, name: String, username: String): RegisterUser

    suspend fun sendAuthCode(phone: String): CodeStatus

    suspend fun checkAuthCode(phone: String, code: String): AuthUser

    suspend fun getUserName(): String

}