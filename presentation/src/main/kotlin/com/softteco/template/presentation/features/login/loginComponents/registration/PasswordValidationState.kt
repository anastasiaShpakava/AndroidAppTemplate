package com.softteco.template.presentation.features.login.loginComponents.registration

data class PasswordValidationState(
    val hasMinimum: Boolean = false,
    val hasCapitalizedLetter: Boolean = false,
    val successful: Boolean = false
)
