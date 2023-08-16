package com.softteco.template.domain.usecase.user

import com.softteco.template.domain.model.user.LoginAuthDto
import com.softteco.template.domain.repository.user.LoginResponse
import com.softteco.template.domain.repository.user.UserRepository
import javax.inject.Inject

internal class LoginUseCaseImpl @Inject constructor(
    private val repository: UserRepository
) : LoginUseCase {
    override suspend fun invoke(userAuth: LoginAuthDto): LoginResponse {
      return  repository.login(
            userAuth
        )
    }
}