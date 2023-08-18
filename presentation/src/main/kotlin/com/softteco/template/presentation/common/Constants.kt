package com.softteco.template.presentation.common

/**
 * Object class to store constants
 * @property EMAIL_PATTERN regular expression is a sequence of characters that forms a email pattern
 * @property TIMEOUT_VALIDATION_PROCESS
 */
object Constants {
    const val EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$"
    const val TIMEOUT_VALIDATION_PROCESS = 5000L
}
