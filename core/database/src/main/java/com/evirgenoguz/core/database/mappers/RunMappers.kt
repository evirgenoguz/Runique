package com.evirgenoguz.core.database.mappers

import com.evirgenoguz.core.database.entity.RunEntity
import com.evirgenoguz.core.domain.location.Location
import com.evirgenoguz.core.domain.run.Run
import org.bson.types.ObjectId
import java.time.Instant
import java.time.ZoneId
import kotlin.time.Duration.Companion.milliseconds

fun RunEntity.toRun(): Run {
    return Run(
        id = id,
        duration = durationMillis.milliseconds,
        dateTimeUtc = Instant.parse(dateTimeUtc)
            .atZone(ZoneId.of("UTC")),
        distanceMeters = distanceInMeters,
        location = Location(
            lat = latitude,
            long = longitude
        ),
        maxSpeedKmH = maxSpeedKmH,
        totalElevationMeters = totalElevationMeters,
        mapPictureUrl = mapPictureUrl
    )
}

fun Run.toRunEntity(): RunEntity {
    return RunEntity(
        id = id ?: ObjectId().toHexString(),
        durationMillis = duration.inWholeMilliseconds,
        maxSpeedKmH = maxSpeedKmH,
        dateTimeUtc = dateTimeUtc.toInstant().toString(),
        latitude = location.lat,
        longitude = location.long,
        distanceInMeters = distanceMeters,
        totalElevationMeters = totalElevationMeters,
        avgSpeedKmH = avgSpeedKmH,
        mapPictureUrl = mapPictureUrl
    )
}