package com.softteco.template.domain.usecase.user

import com.softteco.template.domain.model.user.LoginAuthDto
import com.softteco.template.domain.repository.user.LoginResponse

interface LoginUseCase {
    suspend operator fun invoke(userAuth: LoginAuthDto): LoginResponse
}
