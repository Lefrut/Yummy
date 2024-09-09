package com.example.domain.usecase

import com.example.domain.datastore.DataStoreManager
import com.example.domain.entity.CodeStatus
import com.example.domain.entity.User
import com.example.domain.repository.UserRepository
import com.google.i18n.phonenumbers.PhoneNumberUtil
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserInteractor @Inject constructor(
    private val userRepository: UserRepository,
    private val dataStoreManager: DataStoreManager
) : SendAuthPhoneUseCase, LoginUseCase, RegisterUseCase, GetUserNameUsecase {

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
        return kotlin.runCatching {
            userRepository.sendAuthCode(phone)
        }
    }

    override suspend fun login(phone: String, code: String): Result<User> = runCatching {
        val authUser = userRepository.checkAuthCode(phone, code)
        if (authUser.haveUser) {
            dataStoreManager.apply {
                saveUserId(authUser.userId)
                saveToken(authUser.token)
                saveRefreshToken(authUser.refreshToken)
            }
        }
        return@runCatching User(authUser.haveUser, authUser.userId)
    }

    override suspend fun register(phone: String, name: String, username: String): Result<Unit> = kotlin.runCatching {
        val registerUser = userRepository.register(phone, name, username)
        if(registerUser.refreshToken.isBlank() || registerUser.accessToken.isBlank()) throw Throwable("validation error")

        dataStoreManager.apply {
            saveUserId(registerUser.userId)
            saveRefreshToken(registerUser.refreshToken)
            saveToken(registerUser.accessToken)
        }

        return@runCatching Unit
    }

    override suspend fun getUserName(): Result<String> = kotlin.runCatching {
        return@runCatching userRepository.getUserName()
    }


}