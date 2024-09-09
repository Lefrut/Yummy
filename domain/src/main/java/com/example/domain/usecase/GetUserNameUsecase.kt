package com.example.domain.usecase

interface GetUserNameUsecase: UseCase {

    suspend fun getUserName(): Result<String>

}