package com.evirgenoguz.run.presentation.active_run

import com.evirgenoguz.core.domain.location.Location
import com.evirgenoguz.run.domain.RunData
import kotlin.time.Duration

data class ActiveRunState(
    val elapsedTime: Duration = Duration.ZERO,
    val runData: RunData = RunData(),
    val shouldTrack: Boolean = false,
    val hasStartedRunning: Boolean = false,
    val currentLocation: Location? = null,
    val isRunFinished: Boolean = false,
    val isSavingRun: Boolean = false,
    val distanceInMeters: Double = 0.0,
    val isRunning: Boolean = false,
    val showLocationRationale: Boolean = false,
    val showNotificationRationale: Boolean = false
)
