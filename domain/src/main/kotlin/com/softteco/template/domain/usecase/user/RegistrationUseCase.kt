package com.softteco.template.domain.usecase.user

import com.softteco.template.domain.model.user.CreateUserDto
import com.softteco.template.domain.model.user.LoginAuthDto
import com.softteco.template.domain.repository.user.RegisterResponse

interface RegistrationUseCase {
    suspend operator fun invoke(user: CreateUserDto): RegisterResponse
}