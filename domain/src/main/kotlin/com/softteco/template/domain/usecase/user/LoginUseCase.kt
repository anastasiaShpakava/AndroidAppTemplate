package com.softteco.template.domain.usecase.user

import com.softteco.template.domain.model.user.LoginAuthDto
import com.softteco.template.domain.repository.user.LoginResponse

/**
 * Interface of API Login UseCase
 */
interface LoginUseCase {
    /**
     * UseCase Method to handling Login
     */
    suspend operator fun invoke(userAuth: LoginAuthDto): LoginResponse
}
