package com.evirgenoguz.auth.presentation.login

import androidx.compose.foundation.text.input.TextFieldState

data class LoginState(
    val email: TextFieldState = TextFieldState(initialText = "evirgenoguz48@gmail.com"),
    val password: TextFieldState = TextFieldState(initialText = "Test123456"),
    val isPasswordVisible: Boolean = false,
    val canLogin: Boolean = false,
    val isLoggingIn: Boolean = false,
)