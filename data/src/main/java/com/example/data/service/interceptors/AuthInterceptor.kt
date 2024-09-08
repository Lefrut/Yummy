package com.example.data.service.interceptors

import com.example.data.service.UserService
import com.example.data.service.model.Authenticated
import com.example.data.service.model.RefreshToken
import com.example.domain.datastore.DataStoreManager
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AuthInterceptor @Inject constructor(
    private val datastoreManager: DataStoreManager,
) : Interceptor {

    @Inject
    lateinit var userService: UserService

    override fun intercept(chain: Interceptor.Chain): Response = runBlocking {

        val request = chain.request()
        val isAuthenticated = request.tag(Invocation::class.java)
            ?.method()
            ?.getAnnotation(Authenticated::class.java) != null

        if (isAuthenticated) {
            val accessToken = datastoreManager.token.firstOrNull() ?: ""
            val refreshToken = datastoreManager.refreshToken.firstOrNull() ?: ""

            val newRequest = request.newBuilder()
                .addHeader("Authorization", "Bearer $accessToken")
                .build()

            val response = chain.proceed(newRequest)

            return@runBlocking if (response.code == 401) {
                val registerToken = userService.refreshToken(RefreshToken(refreshToken))
                val (newRefreshToken, newAccesstoken) = with(
                    registerToken?.body() ?: return@runBlocking response
                ) {
                    (this.refreshToken ?: return@runBlocking response) to
                            (this.accessToken ?: return@runBlocking response)
                }
                datastoreManager.saveToken(newAccesstoken)
                datastoreManager.saveRefreshToken(newRefreshToken)

                response
            } else response
        } else {
            return@runBlocking chain.proceed(request)
        }
    }
}