package com.example.domain.repository

import com.example.domain.entity.AuthUser
import com.example.domain.entity.CodeStatus

interface UserRepository {

    suspend fun sendAuthCode(phone: String): Result<CodeStatus>

    suspend fun checkAuthCode(phone: String, code: String): Result<AuthUser>

}