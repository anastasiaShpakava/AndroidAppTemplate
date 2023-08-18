package com.softteco.template.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.softteco.template.data.source.local.model.ApiEntryEntity
import kotlinx.coroutines.flow.Flow

/**
 * Provide methods for data base
 */
@Dao
interface ApiEntryDao {

    /**
     * Method to add entities to database
     */
    @Insert
    suspend fun addAll(items: List<ApiEntryEntity>)

    /**
     * Method to remove entities from database
     */
    @Query("DELETE from ApiEntryEntity")
    suspend fun deleteAll()

    /**
     * Method to get entities from database
     */
    @Query("SELECT * from ApiEntryEntity")
    fun allApiEntries(): Flow<List<ApiEntryEntity>>

    /**
     * Method to add entity to database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOne(entry: ApiEntryEntity)

    /**
     * Method to get entity from database by name
     */
    @Query("SELECT * from ApiEntryEntity WHERE name = :name")
    fun apiEntry(name: String): Flow<ApiEntryEntity?>

    /**
     * Method to get entity from database by favourite
     */
    @Query("SELECT * from ApiEntryEntity WHERE favorite = 1")
    fun favourites(): Flow<List<ApiEntryEntity>>

    /**
     * Method to replace entity in database
     */
    @Transaction
    suspend fun replaceDataset(newEntries: List<ApiEntryEntity>) {
        deleteAll()
        addAll(newEntries)
    }
}
