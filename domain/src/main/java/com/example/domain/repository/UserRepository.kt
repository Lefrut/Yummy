package com.example.domain.repository

import com.example.domain.entity.CodeStatus

interface UserRepository {

    suspend fun sendAuthCode(phone: String): Result<CodeStatus>

}