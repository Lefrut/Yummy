package com.example.data.service

const val BASE_URL = "https://plannerok.ru/api/v1/users/"

data object Endpoints {

    const val POST_SEND_AUTH_CODE = "send-auth-code/"
    const val POST_CHECK_AUTH_CODE = "check-auth-code/"
    const val POST_REFRESH_TOKEN = "refresh-token/"
    const val POST_REGISTER = "register/"

    const val GET_USER = "me/"

}