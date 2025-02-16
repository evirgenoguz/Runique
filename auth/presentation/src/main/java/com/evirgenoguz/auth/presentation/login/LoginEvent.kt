package com.evirgenoguz.auth.presentation.login

import com.evirgenoguz.core.presentation.ui.UiText

sealed interface LoginEvent {

    data object LoginSuccess: LoginEvent
    data class Error(val error: UiText) : LoginEvent

}