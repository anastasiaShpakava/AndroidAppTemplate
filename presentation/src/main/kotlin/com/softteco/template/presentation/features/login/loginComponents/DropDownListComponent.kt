package com.softteco.template.presentation.features.login.loginComponents

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DropDownListComponent(
    list: List<String>,
    request: (Boolean) -> Unit,
    requestToOpen: Boolean = false,
    selectedString: (String) -> Unit
) {
    DropdownMenu(expanded = requestToOpen, onDismissRequest = { request(false) }) {
        list.forEach {
            DropdownMenuItem(text = { Text(text = it) }, onClick = {
                request(false)
                selectedString(it)
            })
        }
    }
}
