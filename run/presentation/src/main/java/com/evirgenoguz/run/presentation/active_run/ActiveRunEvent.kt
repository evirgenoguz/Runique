package com.evirgenoguz.run.presentation.active_run

import com.evirgenoguz.core.presentation.ui.UiText

sealed interface ActiveRunEvent {
    data class Error(val error: UiText) : ActiveRunEvent
    data object RunSaved: ActiveRunEvent
}