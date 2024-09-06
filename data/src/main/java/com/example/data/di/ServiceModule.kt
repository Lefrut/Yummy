package com.example.data.di

import com.example.data.service.BASE_URL
import com.example.data.service.UserService
import com.example.data.service.interceptors.httpLoggingInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    private val json = Json { ignoreUnknownKeys = true }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder().client(client).baseUrl(BASE_URL).addConverterFactory(
        json.asConverterFactory("application/json".toMediaType())
    ).build()

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): UserService = retrofit.create(UserService::class.java)


    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor()).build()



}