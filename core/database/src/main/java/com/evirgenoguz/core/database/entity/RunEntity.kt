package com.evirgenoguz.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.bson.types.ObjectId

@Entity
data class RunEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String = ObjectId().toHexString(),
    val durationMillis: Long,
    val distanceInMeters: Int,
    val dateTimeUtc: String,
    val latitude: Double,
    val longitude: Double,
    val avgSpeedKmH: Double,
    val maxSpeedKmH: Double,
    val totalElevationMeters: Int,
    val mapPictureUrl: String?
)
