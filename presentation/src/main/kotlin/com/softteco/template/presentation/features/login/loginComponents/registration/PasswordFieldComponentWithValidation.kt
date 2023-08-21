package com.softteco.template.presentation.features.login.loginComponents.registration

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.softteco.template.presentation.R
import com.softteco.template.presentation.features.login.PasValidationViewModel

/**
 * Password field component with validation
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFieldComponentWithValidation(
    viewModel: PasValidationViewModel,
    fieldNameErrorState: MutableState<Boolean>,
    passwordVisibility: MutableState<Boolean>,
    modifier: Modifier = Modifier
) {
    val passwordError by viewModel.passwordError.collectAsState()

    Column {
        OutlinedTextField(
            value = viewModel.password,
            onValueChange = {
                if (fieldNameErrorState.value) {
                    fieldNameErrorState.value = false
                }
                viewModel.changePassword(it)
            },
            modifier = modifier,
            label = {
                Text(text = stringResource(id = R.string.password))
            },
            isError = fieldNameErrorState.value,
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
        if (fieldNameErrorState.value) {
            Text(text = stringResource(id = R.string.required), color = Color.Red)
        }
        Spacer(modifier = Modifier.height(8.dp))

        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
            ConditionRow(
                condition = stringResource(R.string.registration_password_condition1),
                check = passwordError.hasMinimum,
                modifier = Modifier.fillMaxSize()
            )
            ConditionRow(
                condition = stringResource(R.string.registration_password_condition1),
                check = passwordError.hasCapitalizedLetter,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

/**
 * Provide animate changing of the input password
 */
@Composable
fun ConditionRow(
    condition: String,
    check: Boolean,
    modifier: Modifier = Modifier
) {
    val color by animateColorAsState(
        targetValue = if (check) Color.Green else Color.Red
    )

    val icon = if (check) {
        Icons.Rounded.Check
    } else {
        Icons.Rounded.Close
    }

    Row(modifier = modifier) {
        Icon(
            imageVector = icon,
            tint = color,
            contentDescription = stringResource(id = R.string.icon_description)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = condition,
            color = color
        )
    }
}
