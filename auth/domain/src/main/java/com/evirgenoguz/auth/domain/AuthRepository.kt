package com.evirgenoguz.auth.domain

import com.evirgenoguz.core.domain.util.DataError
import com.evirgenoguz.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>

    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
}