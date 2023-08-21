package com.softteco.template.presentation.features.login.loginComponents

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.softteco.template.presentation.R

/**
 * Provide simple button component
 */
@Composable
fun SimpleButtonComponent(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        shape = RoundedCornerShape(50.dp),
        modifier = modifier,
        onClick = { onClick },
        content = {
            Text(text = stringResource(id = R.string.sign_up), color = Color.White)
        },
    )
}
