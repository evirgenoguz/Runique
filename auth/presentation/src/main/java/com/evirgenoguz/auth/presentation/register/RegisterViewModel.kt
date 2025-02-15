package com.evirgenoguz.auth.presentation.register

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evirgenoguz.auth.domain.UserDataValidator
import com.evirgenoguz.core.presentation.ui.textAsFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class RegisterViewModel(
    private val userDataValidator: UserDataValidator
) : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    init {
        state.email.textAsFlow().onEach { email ->
            val isValidEmail = userDataValidator.isValidEmail(email.toString())
            state = state.copy(
                isEmailValid = isValidEmail,
                canRegister = isValidEmail && state.passwordValidationState.isValidPassword && !state.isRegistering
            )
        }.launchIn(viewModelScope)

        state.password.textAsFlow().onEach { password ->
            val passwordValidationState = userDataValidator.validatePassword(password.toString())
            state = state.copy(
                passwordValidationState = passwordValidationState,
                canRegister = state.isEmailValid && passwordValidationState.isValidPassword && !state.isRegistering
            )
        }.launchIn(viewModelScope)
    }

    fun onAction(action: RegisterAction) {
        when (action) {
            RegisterAction.OnLoginClick -> {

            }

            RegisterAction.OnRegisterClick -> Log.d("deneme", "on register")
            RegisterAction.OnTogglePasswordVisibilityClick -> Log.d("deneme", "on toggle")
        }
    }
}