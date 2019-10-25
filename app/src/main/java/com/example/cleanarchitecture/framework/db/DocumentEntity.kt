package com.example.cleanarchitecture.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "document")
class DocumentEntity (
    @PrimaryKey val uri: String,
    @ColumnInfo val name: String,
    @ColumnInfo val size: Int,
    @ColumnInfo val thumbnail: String
)