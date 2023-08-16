package ru.otus.basicarchitecture.internetAdrdess

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.Request


class AuthInterceptor : Interceptor {                              //перехват запроса на сервер с добавлением в него ключа?
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val authenticatedRequest = request.newBuilder()
            .header("Authorization", "Token $API_KEY")
            .build()
        return chain.proceed(authenticatedRequest)
    }
    companion object {
        private const val API_KEY = "932cac66f75626ad387e5cb2f3dd5442b5fb0203"
    }
}