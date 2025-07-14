package com.evirgenoguz.auth.presentation.register

import androidx.compose.foundation.text.input.TextFieldState
import com.evirgenoguz.auth.domain.PasswordValidationState

data class RegisterState(
    val email: TextFieldState = TextFieldState(initialText = "evirgenoguz48@gmail.com"),
    val isEmailValid: Boolean = false,
    val password: TextFieldState = TextFieldState(initialText = "Test123456"),
    val isPasswordVisible: Boolean = false,
    val passwordValidationState: PasswordValidationState = PasswordValidationState(),
    val isRegistering: Boolean = false,
    val canRegister: Boolean = passwordValidationState.isValidPassword && !isRegistering
)
