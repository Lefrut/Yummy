package com.example.domain.usecase

import com.example.domain.datastore.DataStoreManager
import com.example.domain.entity.CodeStatus
import com.example.domain.entity.User
import com.example.domain.repository.UserRepository
import com.google.i18n.phonenumbers.PhoneNumberUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserInteractor @Inject constructor(
    private val userRepository: UserRepository,
    private val dataStoreManager: DataStoreManager
) :
    SendAuthPhoneUseCase, LoginUseCase {

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

    override suspend fun login(phone: String, code: String): Result<User> = runCatching {
        val authUserResult = userRepository.checkAuthCode(phone, code)
        authUserResult.onFailure { th ->
            throw th
        }
        authUserResult.onSuccess { authUser ->
            if (authUser.haveUser) {
                dataStoreManager.apply {
                    saveUserId(authUser.userId)
                    saveToken(authUser.token)
                    saveRefreshToken(authUser.refreshToken)
                }
            }
            return@runCatching User(authUser.haveUser, authUser.userId)
        }

        throw Throwable("unkonwn")
    }


}