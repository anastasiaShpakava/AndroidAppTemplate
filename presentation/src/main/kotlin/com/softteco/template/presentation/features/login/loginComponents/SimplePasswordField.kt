package com.softteco.template.presentation.features.login.loginComponents

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import com.softteco.template.presentation.R

/**
 * Provide component with password
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimplePasswordField(
    password: MutableState<TextFieldValue>,
    passwordErrorState: MutableState<Boolean>,
    passwordVisibility: MutableState<Boolean>,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = password.value,
        onValueChange = {
            if (passwordErrorState.value) {
                passwordErrorState.value = false
            }
            password.value = it
        },
        isError = passwordErrorState.value,
        modifier = modifier,
        label = {
            Text(text = stringResource(id = R.string.password))
        },
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility.value = !passwordVisibility.value
            }) {
                Icon(
                    imageVector = if (passwordVisibility.value) {
                        Icons.Default.VisibilityOff
                    } else {
                        Icons.Default.Visibility
                    },
                    contentDescription = stringResource(R.string.visibility),
                    tint = Color.Black
                )
            }
        },
        visualTransformation = if (passwordVisibility.value) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        }
    )
}
