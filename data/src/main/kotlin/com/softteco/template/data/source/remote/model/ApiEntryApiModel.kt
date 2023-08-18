package com.softteco.template.data.source.remote.model

import com.softteco.template.data.source.local.model.ApiEntryEntity
import com.softteco.template.domain.model.ApiEntry
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Entry API Model
 * @param count entries count
 * @param entries entries list
 */
@JsonClass(generateAdapter = true)
data class ApiEntryApiModels(
    @Json(name = "count")
    val count: Int,
    @Json(name = "entries")
    val entries: List<ApiEntryApiModel>
)

/**
 * Entry API Model data class
 * @param name
 * @param auth
 * @param category
 * @param cors
 * @param description
 * @param https
 * @param link
 */
@JsonClass(generateAdapter = true)
data class ApiEntryApiModel(
    @Json(name = "API")
    val name: String,
    @Json(name = "Auth")
    val auth: String,
    @Json(name = "Category")
    val category: String,
    @Json(name = "Cors")
    val cors: String,
    @Json(name = "Description")
    val description: String,
    @Json(name = "HTTPS")
    val https: Boolean,
    @Json(name = "Link")
    val link: String
)

internal fun ApiEntryApiModel.toDomainModel() = ApiEntry(
    name = name,
    auth = auth,
    category = category,
    cors = cors,
    description = description,
    https = https,
    link = link,
    logo = "https://api.dicebear.com/5.x/icons/svg?seed=$name",
    favorite = false,
)

internal fun ApiEntryApiModel.toEntity() = ApiEntryEntity(
    name = name,
    auth = auth,
    category = category,
    cors = cors,
    description = description,
    https = https,
    link = link,
    logo = "https://api.dicebear.com/5.x/icons/svg?seed=$name",
    favorite = false,
)
