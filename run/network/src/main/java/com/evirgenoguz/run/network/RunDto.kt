package com.evirgenoguz.run.network

import kotlinx.serialization.Serializable

@Serializable
data class RunDto(
    val id: String,
    val dateTimeUtc: String,
    val durationMillis: Long,
    val distanceMeters: Int,
    val lat: Double,
    val long: Double,
    val avgSpeedKmH: Double,
    val maxSpeedKmH: Double,
    val totalElevationMeters: Int,
    val mapPictureUrl: String?
)
