package com.softteco.template.domain.repository.user

import com.softteco.template.domain.model.user.ApiResponse
import com.softteco.template.domain.model.user.CreateUserDto
import com.softteco.template.domain.model.user.LoginAuthDto

/**
 * Response from login action declaration
 */
typealias LoginResponse = ApiResponse<Boolean>

/**
 * Response from registrationaction declaration
 */
typealias RegisterResponse = ApiResponse<Boolean>

/**
 * User API repository
 */
interface UserRepository {
    /**
     *
     */
    suspend fun login(userAuth: LoginAuthDto): LoginResponse

    /**
     * Provide registration Api's method
     */
    suspend fun registration(user: CreateUserDto): RegisterResponse
}
