package com.example.domain.usecase

import com.example.domain.entity.CodeStatus

interface SendAuthPhoneUseCase: UseCase {

    suspend fun sendAuthCode(phone: String): Result<CodeStatus>

}
