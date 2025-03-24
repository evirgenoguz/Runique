package com.evirgenoguz.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.evirgenoguz.core.database.entity.DeletedRunSyncEntity
import com.evirgenoguz.core.database.entity.RunPendingSyncEntity

@Dao
interface RunPendingSyncDao {

    // CREATED RUNS
    @Query("Select * From runpendingsyncentity Where userId = :userId")
    suspend fun getAllRunPendingSyncEntities(userId: String): List<RunPendingSyncEntity>

    @Query("Select * From runpendingsyncentity Where runId = :runId")
    suspend fun getRunPendingSyncEntity(runId: String): RunPendingSyncEntity?

    @Upsert
    suspend fun upsertRunPendingSyncEntity(entity: RunPendingSyncEntity)

    @Query("Delete From runpendingsyncentity Where runId = :runId")
    suspend fun deleteRunPendingSyncEntity(runId: String)


    // DELETED RUNS

    @Query("SELECT * FROM deletedrunsyncentity WHERE userId=:userId")
    suspend fun getAllDeletedRunSyncEntities(userId: String): List<DeletedRunSyncEntity>

    @Upsert
    suspend fun upsertDeletedRunSyncEntity(entity: DeletedRunSyncEntity)

    @Query("DELETE FROM deletedrunsyncentity WHERE runId=:runId")
    suspend fun deleteDeletedRunSyncEntity(runId: String)

}