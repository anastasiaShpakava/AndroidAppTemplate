package com.softteco.template.data

/**
 * Custom exception for API error handling
 */

class ApiException(message: String? = null, cause: Throwable? = null) : Exception(message, cause)
