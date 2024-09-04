package com.example.domain.usecase

import android.telephony.PhoneNumberUtils
import com.example.domain.entity.CodeStatus
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserInteractor @Inject constructor(private val userRepository: UserRepository) :
    SendAuthPhoneUseCase {

    override suspend fun sendAuthCode(phone: String): Result<CodeStatus> {
        if (PhoneNumberUtils.isGlobalPhoneNumber(phone)) return kotlin.runCatching {
            throw IllegalArgumentException(
                "bad number"
            )
        }

        return withContext(Dispatchers.IO) {
            return@withContext userRepository.sendAuthCode(phone)
        }
    }


}