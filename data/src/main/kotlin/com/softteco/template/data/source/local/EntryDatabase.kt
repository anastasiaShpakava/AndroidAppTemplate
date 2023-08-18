package com.softteco.template.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.softteco.template.data.Config
import com.softteco.template.data.source.local.model.ApiEntryEntity

/**
 * Data base creating
 */
@Database(
    entities = [ApiEntryEntity::class],
    version = 1,
    exportSchema = true
)
abstract class EntryDatabase : RoomDatabase() {

    /**
     * Provide ApiEntryDao
     */
    abstract fun apiEntryDao(): ApiEntryDao

    companion object {
        /**
         * Method to create the database.
         */
        fun create(applicationContext: Context): EntryDatabase {
            return Room.databaseBuilder(
                applicationContext,
                EntryDatabase::class.java,
                Config.DB_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
