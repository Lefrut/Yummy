package com.example.domain.usecase

import com.example.domain.entity.User

interface LoginUseCase : UseCase {


    suspend fun login(phone: String, code: String): Result<User>

}