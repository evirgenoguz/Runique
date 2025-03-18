package com.evirgenoguz.core.domain.run

import com.evirgenoguz.core.domain.util.DataError
import com.evirgenoguz.core.domain.util.Result
import kotlinx.coroutines.flow.Flow

typealias RunId = String

interface LocalRunDataSource {
    suspend fun upsertRun(run: Run): Result<RunId, DataError.Local>
    suspend fun upsertRuns(runList: List<Run>): Result<List<RunId>, DataError.Local>
    suspend fun getRuns(): Flow<List<Run>>
    suspend fun deleteRun(id: String)
    suspend fun deleteAllRuns()
}