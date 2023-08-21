package com.softteco.template.data.di

import android.content.Context
import com.softteco.template.data.source.local.ApiEntryDao
import com.softteco.template.data.source.local.EntryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Provide Local Database Module
 */
@Module
@InstallIn(SingletonComponent::class)
class LocalDatabaseModule {

    /**
     * Provide database to CACHE data from a remote service
     */
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): EntryDatabase =
        EntryDatabase.create(appContext)

    /**
     * Provide API for entry
     */
    @Provides
    fun provideApiEntryDao(entryDatabase: EntryDatabase): ApiEntryDao =
        entryDatabase.apiEntryDao()
}
