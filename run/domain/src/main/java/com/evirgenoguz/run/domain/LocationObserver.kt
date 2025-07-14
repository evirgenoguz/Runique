package com.evirgenoguz.run.domain

import com.evirgenoguz.core.domain.location.LocationWithAltitude
import kotlinx.coroutines.flow.Flow

interface LocationObserver {
    fun observeLocation(interval: Long): Flow<LocationWithAltitude>
}