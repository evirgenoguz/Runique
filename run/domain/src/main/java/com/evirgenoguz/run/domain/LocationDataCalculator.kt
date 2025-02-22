package com.evirgenoguz.run.domain

import com.evirgenoguz.core.domain.location.LocationTimeStamp
import kotlin.math.roundToInt

object LocationDataCalculator {

    fun getTotalDistanceMeters(locations: List<List<LocationTimeStamp>>): Int {
        return locations.sumOf { timestampsPerLine ->
            timestampsPerLine.zipWithNext { location1, location2 ->
                location1.location.location.distanceTo(location2.location.location)
            }.sum().roundToInt()
        }
    }
}