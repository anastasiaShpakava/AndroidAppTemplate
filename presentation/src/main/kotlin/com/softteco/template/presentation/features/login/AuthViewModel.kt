package com.softteco.template.presentation.features.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softteco.template.domain.model.user.*
import com.softteco.template.domain.repository.user.LoginResponse
import com.softteco.template.domain.repository.user.RegisterResponse
import com.softteco.template.domain.usecase.user.LoginUseCase
import com.softteco.template.domain.usecase.user.RegistrationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registrationUseCase: RegistrationUseCase
) : ViewModel() {

    var loginApiResponse by mutableStateOf<LoginResponse>(ApiResponse.Success(false))

    var registerApiResponse by mutableStateOf<RegisterResponse>(ApiResponse.Success(false))

    fun login(
        userAuth: LoginAuthDto
    ) = viewModelScope.launch {
        loginApiResponse = ApiResponse.Loading
        loginApiResponse =
            loginUseCase.invoke(userAuth)
    }

    fun register(
        user: CreateUserDto
    ) {
        viewModelScope.launch {
            registerApiResponse = ApiResponse.Loading
            registerApiResponse =
                registrationUseCase.invoke(user)
        }
    }
}
