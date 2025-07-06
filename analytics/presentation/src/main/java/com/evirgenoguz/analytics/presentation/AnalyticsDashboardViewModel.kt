package com.evirgenoguz.analytics.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evirgenoguz.analytics.domain.RunAnalyticsRepository
import kotlinx.coroutines.launch

class AnalyticsDashboardViewModel(
    private val runAnalyticsRepository: RunAnalyticsRepository
): ViewModel() {

    var state by mutableStateOf<AnalyticsDashboardState?>(null)
        private set

    init {
        viewModelScope.launch {
            state = runAnalyticsRepository.getAnalyticsValues().toAnalyticsDashboardState()
        }
    }

}