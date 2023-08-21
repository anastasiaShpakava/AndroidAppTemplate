package com.softteco.template.presentation.features.login.loginComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.softteco.template.presentation.R

/**
 * Provide component with drop down component
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithDropDownComponent(
    country: MutableState<String>,
    countryErrorState: MutableState<Boolean>,
    countryList: List<String>,
    modifier: Modifier = Modifier
) {
    val userSelectedString: (String) -> Unit = {
        country.value = it
    }
    val isOpen = remember { mutableStateOf(false) }
    val openCloseOfDropDownList: (Boolean) -> Unit = {
        isOpen.value = it
    }
    Box(modifier = modifier) {
        Column {
            OutlinedTextField(
                value = country.value,
                onValueChange = {
                    if (countryErrorState.value) {
                        countryErrorState.value = false
                    }
                    country.value = it
                },

                modifier = Modifier.fillMaxWidth(),
                isError = countryErrorState.value,
                label = {
                    Text(text = stringResource(id = R.string.country))
                },
            )
            DropDownListComponent(
                list = countryList,
                openCloseOfDropDownList,
                modifier = Modifier.fillMaxSize(),
                requestToOpen = isOpen.value,
                userSelectedString
            )
        }
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Transparent)
                .padding(10.dp)
                .clickable(onClick = { isOpen.value = true })
        )
    }
}
