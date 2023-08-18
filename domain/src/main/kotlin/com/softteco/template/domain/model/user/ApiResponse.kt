package com.softteco.template.domain.model.user

/**
 * Generic class for holding success response, error response and loading status
 */
sealed class ApiResponse<out T> {

    /**
     * Loading while response handling
     */
    object Loading : ApiResponse<Nothing>()

    /**
     * Successful response handling
     * @property data action when response is Successful
     */
    data class Success<out T>(
        val data: T
    ) : ApiResponse<T>()

    /**
     * Failure response handling
     * @property e action when response is Failure
     */
    data class Failure(
        val e: Exception?
    ) : ApiResponse<Nothing>()
}
