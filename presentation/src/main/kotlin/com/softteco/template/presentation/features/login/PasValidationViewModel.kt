package com.softteco.template.presentation.features.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softteco.template.presentation.common.Constants
import com.softteco.template.presentation.features.login.loginComponents.registration
.PasswordValidationState
import com.softteco.template.presentation.features.login.loginComponents.registration
.ValidatePassword
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn

/**
 * Implementation of viewModel for password validation
 * @property password inputted password
 */
class PasValidationViewModel(
    private val validatePassword: ValidatePassword = ValidatePassword()
) : ViewModel() {
    var password by mutableStateOf("")
        private set

    /**
     * Error handling with invalid password
     */
    @OptIn(ExperimentalCoroutinesApi::class)
    val passwordError =
        snapshotFlow { password }
            .mapLatest { validatePassword.execute(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(Constants.TIMEOUT_VALIDATION_PROCESS),
                initialValue = PasswordValidationState()
            )

    /**
     * Observation of the input characters
     */
    fun changePassword(value: String) {
        password = value
    }
}
