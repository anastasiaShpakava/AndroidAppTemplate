package com.softteco.template.domain.model.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Data class for login user
 * @property email
 * @property password
 */
@Parcelize
data class LoginAuthDto(
    val email: String,
    val password: String
) : Parcelable
