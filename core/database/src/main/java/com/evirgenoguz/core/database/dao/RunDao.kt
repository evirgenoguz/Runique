package com.evirgenoguz.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.evirgenoguz.core.database.entity.RunEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RunDao {

    @Upsert
    suspend fun upsertRun(run: RunEntity)

    @Upsert
    suspend fun upsertRuns(runList: List<RunEntity>)

    @Query("Select * from runentity Order By dateTimeUtc Desc")
    fun getRuns(): Flow<List<RunEntity>>

    @Query("Delete From runentity Where id = :id")
    suspend fun deleteRun(id: String)

    @Query("Delete From runentity")
    suspend fun deleteAllRuns()

}
