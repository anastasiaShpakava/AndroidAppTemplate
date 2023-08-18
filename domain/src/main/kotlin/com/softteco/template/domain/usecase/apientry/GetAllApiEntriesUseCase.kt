package com.softteco.template.domain.usecase.apientry

import com.softteco.template.domain.model.ApiEntry
import kotlinx.coroutines.flow.Flow

/**
 * Interface of API Entries UseCase to expose to ui module
 */
interface GetAllApiEntriesUseCase {
    /**
     * UseCase Method to fetch the API entries list from Data Layer
     */
    operator fun invoke(): Flow<List<ApiEntry>>
}
