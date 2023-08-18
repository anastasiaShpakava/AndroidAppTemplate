package com.softteco.template.domain.model.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Data class for user creation (registration)
 * @property firstName
 * @property lastName
 * @property email
 * @property password
 * @property confirmPassword
 * @property country
 * @property birthday
 */
@Parcelize
data class CreateUserDto(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val confirmPassword: String,
    val country: String,
    val birthday: String
) : Parcelable
