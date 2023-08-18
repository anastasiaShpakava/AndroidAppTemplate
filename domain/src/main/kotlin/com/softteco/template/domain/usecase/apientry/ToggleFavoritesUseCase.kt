package com.softteco.template.domain.usecase.apientry

import com.softteco.template.domain.model.ApiEntry

/**
 * Interface of API Entries UseCase to expose to ui module
 */
interface ToggleFavoritesUseCase {

    /**
     * UseCase Method to fetch the API entry by favourite from Data Layer
     */
    suspend operator fun invoke(entry: ApiEntry)
}
