package com.evirgenoguz.run.network

import com.evirgenoguz.core.domain.location.Location
import com.evirgenoguz.core.domain.run.Run
import java.time.Instant
import java.time.ZoneId
import kotlin.time.Duration.Companion.milliseconds

fun RunDto.toRun(): Run {
    return Run(
        id = id,
        duration = durationMillis.milliseconds,
        dateTimeUtc = Instant.parse(dateTimeUtc)
            .atZone(ZoneId.of("UTC")),
        distanceMeters = distanceMeters,
        location = Location(lat, long),
        maxSpeedKmH = maxSpeedKmH,
        totalElevationMeters = totalElevationMeters,
        mapPictureUrl = mapPictureUrl
    )
}

fun Run.toRunDto(): RunDto {
    return RunDto(
        id = id ?: "",
        durationMillis = duration.inWholeMilliseconds,
        maxSpeedKmH = maxSpeedKmH,
        dateTimeUtc = dateTimeUtc.toInstant().toString(),
        lat = location.lat,
        long = location.long,
        distanceMeters = distanceMeters,
        totalElevationMeters = totalElevationMeters,
        avgSpeedKmH = avgSpeedKmH,
        mapPictureUrl = mapPictureUrl
    )
}

fun Run.toCreateRunRequest(): CreateRunRequest {
    return CreateRunRequest(
        durationMillis = duration.inWholeMilliseconds,
        distanceMeters = distanceMeters,
        epochMillis = dateTimeUtc.toEpochSecond() * 1000L,
        lat = location.lat,
        long = location.long,
        avgSpeedKmH = avgSpeedKmH,
        maxSpeedKmH = maxSpeedKmH,
        totalElevationMeters = totalElevationMeters,
        id = id.orEmpty()
    )
}