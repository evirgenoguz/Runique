package com.evirgenoguz.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.evirgenoguz.core.database.dao.AnalyticsDao
import com.evirgenoguz.core.database.dao.RunDao
import com.evirgenoguz.core.database.dao.RunPendingSyncDao
import com.evirgenoguz.core.database.entity.DeletedRunSyncEntity
import com.evirgenoguz.core.database.entity.RunEntity
import com.evirgenoguz.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [
        RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class
    ],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {

    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
    abstract val runAnalyticsDao: AnalyticsDao
}