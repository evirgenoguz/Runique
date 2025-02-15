package com.evirgenoguz.auth.data

import com.evirgenoguz.auth.domain.AuthRepository
import com.evirgenoguz.core.data.networking.post
import com.evirgenoguz.core.domain.util.DataError
import com.evirgenoguz.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient
) : AuthRepository {
    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}