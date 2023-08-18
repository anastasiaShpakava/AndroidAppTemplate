package com.softteco.template.domain.repository.user

import com.softteco.template.domain.model.user.ApiResponse
import com.softteco.template.domain.model.user.CreateUserDto
import com.softteco.template.domain.model.user.LoginAuthDto

typealias LoginResponse = ApiResponse<Boolean>
typealias RegisterResponse = ApiResponse<Boolean>

interface UserRepository {
    suspend fun login(userAuth: LoginAuthDto): LoginResponse

    suspend fun registration(user: CreateUserDto): RegisterResponse
}
