package com.example.domain.datastore

import kotlinx.coroutines.flow.Flow

interface DataStoreManager {
    val token: Flow<String?>
    val refreshToken: Flow<String?>
    val userId: Flow<Int?>

    suspend fun saveToken(token: String)
    suspend fun saveRefreshToken(refreshToken: String)
    suspend fun saveUserId(userId: Int)
    suspend fun clearData()
}
