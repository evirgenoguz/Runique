package com.evirgenoguz.analytics.presentation

sealed interface AnalyticsAction {
    data object OnBackClick: AnalyticsAction
}