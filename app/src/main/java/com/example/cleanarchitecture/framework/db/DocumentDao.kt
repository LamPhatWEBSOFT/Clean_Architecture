package com.example.cleanarchitecture.framework.db

import androidx.room.*
import com.raywenderlich.android.majesticreader.domain.Document

@Dao
interface DocumentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDocument(document: DocumentEntity)

    @Query("select * from document")
    suspend fun getDocument(): List<DocumentEntity>

    @Delete
    suspend fun removeDocument(document: DocumentEntity)
}