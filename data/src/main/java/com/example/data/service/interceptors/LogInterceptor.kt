package com.example.data.service.interceptors

import com.example.data.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor

fun httpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
    level = if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor.Level.BODY
    } else {
        HttpLoggingInterceptor.Level.NONE
    }
}
