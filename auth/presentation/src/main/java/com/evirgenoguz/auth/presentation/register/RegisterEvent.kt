package com.evirgenoguz.auth.presentation.register

import com.evirgenoguz.core.presentation.ui.UiText

sealed interface RegisterEvent {
    data object RegistrationSuccess : RegisterEvent
    data class Error(val error: UiText) : RegisterEvent

}