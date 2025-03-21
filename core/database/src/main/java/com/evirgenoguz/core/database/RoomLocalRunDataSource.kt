package com.evirgenoguz.core.database

import android.database.sqlite.SQLiteFullException
import com.evirgenoguz.core.database.dao.RunDao
import com.evirgenoguz.core.database.mappers.toRun
import com.evirgenoguz.core.database.mappers.toRunEntity
import com.evirgenoguz.core.domain.run.LocalRunDataSource
import com.evirgenoguz.core.domain.run.Run
import com.evirgenoguz.core.domain.run.RunId
import com.evirgenoguz.core.domain.util.DataError
import com.evirgenoguz.core.domain.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomLocalRunDataSource(
    private val runDao: RunDao
) : LocalRunDataSource {
    override suspend fun upsertRun(run: Run): Result<RunId, DataError.Local> {
        return try {
            val runEntity = run.toRunEntity()
            runDao.upsertRun(runEntity)
            Result.Success(runEntity.id)
        } catch (e: SQLiteFullException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun upsertRuns(runList: List<Run>): Result<List<RunId>, DataError.Local> {
        return try {
            val runEntities = runList.map { it.toRunEntity() }
            runDao.upsertRuns(runEntities)
            Result.Success(runEntities.map { it.id })
        } catch (e: SQLiteFullException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override fun getRuns(): Flow<List<Run>> {
        return runDao.getRuns().map { runEntities ->
            runEntities.map { it.toRun() }
        }
    }

    override suspend fun deleteRun(id: String) {
        runDao.deleteRun(id)
    }

    override suspend fun deleteAllRuns() {
        runDao.deleteAllRuns()
    }
}