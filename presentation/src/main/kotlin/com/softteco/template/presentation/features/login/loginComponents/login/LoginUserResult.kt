package com.softteco.template.presentation.features.login.loginComponents.login

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.softteco.template.domain.model.user.ApiResponse
import com.softteco.template.presentation.features.login.AuthViewModel
import com.softteco.template.presentation.features.login.loginComponents.ProgressBar

/**
 * Login result handling
 */
@Composable
fun LoginUserResult(
    viewModel: AuthViewModel = hiltViewModel()
) {
    when (val loginResponse = viewModel.loginApiResponse) {
        is ApiResponse.Loading -> ProgressBar(Modifier.fillMaxSize())
        is ApiResponse.Success -> Unit // TODO (go to user's screen)
        is ApiResponse.Failure -> {
            Toast.makeText(
                LocalContext.current,
                loginResponse.e.toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
