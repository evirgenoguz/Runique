package com.evirgenoguz.analytics.domain

interface RunAnalyticsRepository {
    suspend fun getAnalyticsValues(): AnalyticsValues
}