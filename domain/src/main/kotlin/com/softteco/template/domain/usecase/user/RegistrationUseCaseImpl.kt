package com.softteco.template.domain.usecase.user

import com.softteco.template.domain.model.user.CreateUserDto
import com.softteco.template.domain.repository.user.RegisterResponse
import com.softteco.template.domain.repository.user.UserRepository
import javax.inject.Inject

internal class RegistrationUseCaseImpl @Inject constructor(private val repository: UserRepository) :
    RegistrationUseCase {
    override suspend fun invoke(user: CreateUserDto): RegisterResponse {
        return repository.registration(
            user
        )
    }


}