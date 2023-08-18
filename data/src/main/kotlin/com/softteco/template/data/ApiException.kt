package com.softteco.template.data

import kotlinx.coroutines.CoroutineScope

/**
 * Custom exception for API error handling
 */

class ApiException(message: String? = null, cause: Throwable? = null) : Exception(message, cause)
