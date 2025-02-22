package com.evirgenoguz.run.presentation.active_run.maps

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.evirgenoguz.core.domain.location.LocationTimeStamp
import com.google.android.gms.maps.model.JointType
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Polyline

@Composable
fun RuniquePolyLines(locations: List<List<LocationTimeStamp>>) {
    val polyLines = remember(locations) {
        locations.map {
            it.zipWithNext { timestamp1, timestamp2 ->
                PolyLineUi(
                    location1 = timestamp1.location.location,
                    location2 = timestamp2.location.location,
                    color = PolylineColorCalculator.locationsToColor(
                        location1 = timestamp1,
                        location2 = timestamp2
                    )
                )
            }
        }
    }

    polyLines.forEach { polyLine ->
        polyLine.forEach { polyLineUi ->
            Polyline(
                points = listOf(
                    LatLng(polyLineUi.location1.lat, polyLineUi.location1.long),
                    LatLng(polyLineUi.location2.lat, polyLineUi.location2.long),
                ),
                color = polyLineUi.color,
                jointType = JointType.BEVEL
            )
        }
    }
}