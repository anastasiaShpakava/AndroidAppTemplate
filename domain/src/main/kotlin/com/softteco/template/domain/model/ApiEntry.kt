package com.softteco.template.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Data class for API Entry
 * @property id
 * @property name
 * @property auth
 * @property category
 * @property cors
 * @property description
 * @property https
 * @property link
 * @property logo
 * @property favorite
 */
@Parcelize
data class ApiEntry(
    val id: Int? = null,
    val name: String,
    val auth: String,
    val category: String,
    val cors: String,
    val description: String,
    val https: Boolean,
    val link: String,
    val logo: String,
    val favorite: Boolean
) : Parcelable
