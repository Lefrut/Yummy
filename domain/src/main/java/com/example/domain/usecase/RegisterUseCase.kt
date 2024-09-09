package com.example.domain.usecase

interface RegisterUseCase: UseCase {

    suspend fun register(phone: String, name: String, username: String): Result<Unit>

}