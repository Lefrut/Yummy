package com.example.data.repository

import android.app.admin.SystemUpdatePolicy.ValidationFailedException
import com.example.data.service.UserService
import com.example.data.service.model.CheckAuthCode
import com.example.data.service.model.Phone
import com.example.data.service.model.UserRegisterInfo
import com.example.data.service.model.toAuthUser
import com.example.data.service.model.toRegisterUser
import com.example.domain.entity.AuthUser
import com.example.domain.entity.CodeStatus
import com.example.domain.entity.RegisterUser
import com.example.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserRepositoryImpl @Inject constructor(private val userService: UserService) :
    UserRepository {
    override suspend fun register(phone: String, name: String, username: String): RegisterUser {
        val response = userService.registerUser(
            UserRegisterInfo(name = name, phone = phone, username = username)
        )
        return response.body()?.toRegisterUser() ?: throw Throwable("validation error")
    }

    override suspend fun sendAuthCode(phone: String): CodeStatus {
        val response = userService.sendAuthCode(Phone(phone))
        if (response.isSuccessful) {
            return CodeStatus(
                response.body()?.isSuccess ?: false
            )
        } else {
            throw Throwable("validation error")
        }
    }

    override suspend fun checkAuthCode(phone: String, code: String): AuthUser {
        val authTokenResponse = userService.checkAuthCode(CheckAuthCode(phone, code))
        return (authTokenResponse.body()?.toAuthUser() ?: Throwable("validation error")) as AuthUser
    }
}