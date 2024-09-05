package com.example.domain.usecase

import com.example.domain.entity.CodeStatus
import com.example.domain.repository.UserRepository
import com.google.i18n.phonenumbers.PhoneNumberUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserInteractor @Inject constructor(private val userRepository: UserRepository) :
    SendAuthPhoneUseCase {

    override suspend fun sendAuthCode(phone: String): Result<CodeStatus> {
        val phoneResult = runCatching<CodeStatus> {
            val phoneUtil = PhoneNumberUtil.getInstance()
            if (!phoneUtil.isValidNumber(
                    phoneUtil.parse(
                        phone,
                        null
                    )
                )
            ) {
                throw IllegalArgumentException("bad number")
            } else CodeStatus(false)
        }
        if (phoneResult.isFailure) {
            return phoneResult
        }
        return withContext(Dispatchers.IO) {
            return@withContext userRepository.sendAuthCode(phone)
        }
    }


}