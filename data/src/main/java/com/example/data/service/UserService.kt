package com.example.data.service

import com.example.data.service.model.AuthToken
import com.example.data.service.model.Phone
import com.example.data.service.model.CheckAuthCode
import com.example.data.service.model.SendPhoneResult
import com.example.data.service.model.ServiceErrorResult
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST(Endpoints.POST_SEND_AUTH_CODE)
    suspend fun sendAuthCode(@Body phone: Phone): Response<SendPhoneResult>

    @POST(Endpoints.POST_SEND_AUTH_CODE)
    suspend fun sendAuthCodeError(@Body phone: Phone): Response<ServiceErrorResult>

    @POST(Endpoints.POST_CHECK_AUTH_CODE)
    suspend fun checkAuthCode(@Body checkAuthCode: CheckAuthCode): Response<AuthToken>


}

