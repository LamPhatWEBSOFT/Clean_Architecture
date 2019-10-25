package com.example.clean_architecture.data

import com.raywenderlich.android.majesticreader.domain.Bookmark
import com.raywenderlich.android.majesticreader.domain.Document

interface BookmarkDataSource {
//    This allows you to use coroutine-powered mechanisms in Room, for simpler threading.
    suspend fun add(document: Document, bookmark: Bookmark)

    suspend fun read(document: Document): List<Bookmark>

    suspend fun remove(document: Document, bookmark: Bookmark)
}
