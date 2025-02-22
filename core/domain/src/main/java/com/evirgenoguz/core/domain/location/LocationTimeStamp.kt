package com.evirgenoguz.core.domain.location

import java.time.Duration

data class LocationTimeStamp(
    val location: LocationWithAltitude,
    val durationTimestamp: Duration
)
