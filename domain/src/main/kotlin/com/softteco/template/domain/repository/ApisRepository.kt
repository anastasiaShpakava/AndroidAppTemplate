package com.softteco.template.domain.repository

import com.softteco.template.domain.model.ApiEntry
import com.softteco.template.domain.model.Output
import kotlinx.coroutines.flow.Flow

/**
 * Interface of APIs Repository to expose to other module
 * @property allEntries entries list
 * @property favorites entries by favourite
 */
interface ApisRepository {

    val allEntries: Flow<List<ApiEntry>>

    val favorites: Flow<List<ApiEntry>>

    /**
     * Method to fetch the API entries from Repository
     * @return Flow of Outputs with [ApiEntry] list
     */
    fun fetchApiEntries(): Flow<Output<List<ApiEntry>>>

    /**
     * Method to update entry
     */
    suspend fun updateEntry(entry: ApiEntry)

    /**
     * Method to get entry by name
     */
    fun apiEntry(name: String): Flow<ApiEntry?>

    /**
     * Method to refresh entries list
     */
    fun refresh()
}
