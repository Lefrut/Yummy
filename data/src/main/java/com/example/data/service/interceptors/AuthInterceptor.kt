package com.example.data.service.interceptors

import com.example.data.service.UserService
import com.example.data.service.model.Authenticated
import com.example.domain.datastore.DataStoreManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.firstOrNull
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

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val isAuthenticated = request.tag(Invocation::class.java)
            ?.method()
            ?.getAnnotation(Authenticated::class.java) != null

        val tokenDeffered = CoroutineScope(Dispatchers.IO).async {
            datastoreManager.token.firstOrNull() ?: ""
        }

        /* TODO
        * Если записанное время будет отличаться от нынешнего на 10 минут,
        * то обновляем токен.
        * Либо можно ловить 401 ошибку, и в этот момент обновлять токен.
        * */

        while (true) {
            Thread.sleep(5)
            if (tokenDeffered.isCompleted) break
        }

        val accessToken = try {
            tokenDeffered.getCompleted()
        } catch (ex: Exception) {
            ""
        }


        return if (isAuthenticated) {
            val newRequest = request.newBuilder()
                .addHeader("Authorization", "Bearer $accessToken")
                .build()
            chain.proceed(newRequest)
        } else {
            chain.proceed(request)
        }
    }
}