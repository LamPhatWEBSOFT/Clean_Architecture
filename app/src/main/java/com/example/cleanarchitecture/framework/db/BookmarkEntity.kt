package com.example.cleanarchitecture.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmark")
data class BookmarkEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val documentUri: String,
    @ColumnInfo val page: Int
)