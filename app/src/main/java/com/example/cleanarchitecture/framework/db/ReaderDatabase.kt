package com.example.cleanarchitecture.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(
    entities = [BookmarkEntity::class, DocumentEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ReaderDatabase: RoomDatabase() {
    companion object{
        private const val DATABASE_NAME = "reader.db"
        private var instanse: ReaderDatabase? = null
        private fun create(context: Context): ReaderDatabase =
            Room.databaseBuilder(context, ReaderDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration().build()
        fun getInstance(context: Context): ReaderDatabase =
            (instanse?: create(context)).also { instanse = it }
    }
    abstract fun bookmarkDao(): BookmarkDao
    abstract fun documentDao(): DocumentDao
}