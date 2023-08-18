package com.softteco.template.domain.usecase.apientry

import com.softteco.template.domain.model.ApiEntry
import kotlinx.coroutines.flow.Flow

/**
 * Interface of API Entries UseCase to expose to ui module
 */
interface GetApiEntryByNameUseCase {

    /**
     * UseCase Method to fetch the API entry by name from Data Layer
     */
    operator fun invoke(name: String): Flow<ApiEntry?>
}
