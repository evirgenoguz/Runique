package com.evirgenoguz.auth.domain

class UserDataValidator(
    private val patternValidator: PatternValidator
) {

    fun isValidEmail(email: String): Boolean {
        return patternValidator.matches(email.trim())
    }

    fun validatePassword(password: String): PasswordValidationState {
        val hasMinLength = password.length >= MIN_PASSWORD_LENGTH
        val hasUpperCaseCharacter = password.any { it.isUpperCase() }
        val hasLowerCaseCharacter = password.any { it.isLowerCase() }
        val hasNumber = password.any { it.isDigit() }

        return PasswordValidationState(
            hasMinLength = hasMinLength,
            hasUpperCaseCharacter = hasUpperCaseCharacter,
            hasLowerCaseCharacter = hasLowerCaseCharacter,
            hasNumber = hasNumber
        )
    }

    companion object {
        const val MIN_PASSWORD_LENGTH = 9
    }
}