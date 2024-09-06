package com.example.data.repository

import com.example.data.service.UserService
import com.example.data.service.model.CheckAuthCode
import com.example.data.service.model.Phone
import com.example.data.service.model.toAuthUser
import com.example.domain.entity.AuthUser
import com.example.domain.entity.CodeStatus
import com.example.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserRepositoryImpl @Inject constructor(private val userService: UserService) :
    UserRepository {

    override suspend fun sendAuthCode(phone: String): Result<CodeStatus> = kotlin.runCatching {
        val response = userService.sendAuthCode(Phone(phone))
        if (response.isSuccessful) {
            return@runCatching CodeStatus(
                response.body()?.isSuccess ?: throw Throwable("unknow error")
            )
        } else {
            val errorResponse = userService.sendAuthCodeError(Phone(phone))
            errorResponse.body()?.let {
                throw IllegalArgumentException("did not pass validation")
            }
            throw Throwable("unknow error")
        }
    }

    override suspend fun checkAuthCode(phone: String, code: String): Result<AuthUser> =
        kotlin.runCatching {
            val authTokenResponse = userService.checkAuthCode(CheckAuthCode(phone, code))
            return@runCatching authTokenResponse?.body()?.toAuthUser()
                ?: throw IllegalArgumentException("no auth user")
        }


}