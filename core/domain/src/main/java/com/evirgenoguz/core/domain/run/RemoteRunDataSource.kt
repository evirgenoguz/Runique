package com.evirgenoguz.core.domain.run

import com.evirgenoguz.core.domain.util.DataError
import com.evirgenoguz.core.domain.util.Result

interface RemoteRunDataSource {

    suspend fun getRuns(): Result<List<Run>, DataError.Network>

    suspend fun postRun(run: Run, mapPicture: ByteArray): Result<Run, DataError.Network>

    suspend fun  deleteRun(id: String): Result<Unit, DataError.Network>
}