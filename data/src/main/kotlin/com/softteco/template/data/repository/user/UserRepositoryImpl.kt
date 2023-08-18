package com.softteco.template.data.repository.user

import com.softteco.template.data.ApiException
import com.softteco.template.data.source.remote.UserApiService
import com.softteco.template.domain.model.user.ApiResponse
import com.softteco.template.domain.model.user.CreateUserDto
import com.softteco.template.domain.model.user.LoginAuthDto
import com.softteco.template.domain.repository.user.LoginResponse
import com.softteco.template.domain.repository.user.RegisterResponse
import com.softteco.template.domain.repository.user.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * UserRepository interface implementation
 */
@Singleton
class UserRepositoryImpl @Inject constructor(
    private val apiService: UserApiService
) : UserRepository {

    /**
     * Login implementation
     */
    override suspend fun login(userAuth: LoginAuthDto): LoginResponse {
        return try {
            apiService.login(userAuth)
            ApiResponse.Success(true)
            throw ApiException("This is a detail message for the api exception")
        } catch (e: ApiException) {
            ApiResponse.Failure(e)
        }
    }

    /**
     * Registration implementation
     */
    override suspend fun registration(
        user: CreateUserDto
    ): RegisterResponse {
        return try {
            apiService.registration(
                user
            )
            ApiResponse.Success(true)
            throw ApiException("This is a detail message for the api exception")
        } catch (e: ApiException) {
            ApiResponse.Failure(e)
        }
    }
}
