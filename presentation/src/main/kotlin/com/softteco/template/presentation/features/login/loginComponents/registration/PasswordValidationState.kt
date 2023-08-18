package com.softteco.template.presentation.features.login.loginComponents.registration

/**
 * Class for password validation
 * @param hasMinimum does the password has the required minimum number of characters
 * @param hasCapitalizedLetter does the password has at least one capitalized letter
 * @param successful does the password meet the required requirements
 */
data class PasswordValidationState(
    val hasMinimum: Boolean = false,
    val hasCapitalizedLetter: Boolean = false,
    val successful: Boolean = false
)
