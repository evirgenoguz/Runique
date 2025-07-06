package com.evirgenoguz.core.database.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface AnalyticsDao {

    @Query("Select Sum(distanceInMeters) from runentity")
    suspend fun getTotalDistance(): Int

    @Query("Select Sum(durationMillis) from runentity")
    suspend fun getTotalTime(): Long

    @Query("Select Max(maxSpeedKmH) from runentity")
    suspend fun getMaxRunSpeed(): Double

    @Query("Select Avg(durationMillis/ 60000.0 / (distanceInMeters / 1000.0)) from runentity")
    suspend fun getAvgDistancePerRun(): Double
}