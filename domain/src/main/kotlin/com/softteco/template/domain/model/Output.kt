package com.softteco.template.domain.model

/**
 * Generic class for holding success response, error response and loading status
 * @property status status of response handling
 * @property data response data
 * @property error response error
 * @property message response message
 */
data class Output<out T>(
    val status: Status, val data: T?, val error: ApiError?, val message: String?
) {

    /**
     * Response statuses list
     */
    enum class Status {
        /**
         * Success response
         */

        SUCCESS,

        /**
         * Error response
         */

        ERROR,

        /**
         * Response loading
         */

        LOADING
    }

    companion object {
        /**
         *
         */
        fun <T> success(data: T?): Output<T> {
            return Output(Status.SUCCESS, data, null, null)
        }

        /**
         * Error response handling
         */
        fun <T> error(message: String, error: ApiError?): Output<T> {
            return Output(Status.ERROR, null, error, message)
        }

        /**
         * Loading response handling
         */
        fun <T> loading(data: T? = null): Output<T> {
            return Output(Status.LOADING, data, null, null)
        }
    }

    override fun toString(): String {
        return "Result(status=$status, data=$data, error=$error, message=$message)"
    }
}
