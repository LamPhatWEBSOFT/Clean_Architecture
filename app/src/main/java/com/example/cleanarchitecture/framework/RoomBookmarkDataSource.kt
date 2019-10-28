package com.example.cleanarchitecture.framework

import android.content.Context
import com.example.clean_architecture.data.BookmarkDataSource
import com.example.cleanarchitecture.framework.db.BookmarkEntity
import com.example.cleanarchitecture.framework.db.ReaderDatabase
import com.raywenderlich.android.majesticreader.domain.Bookmark
import com.example.clean_architecture.domain.Document

class RoomBookmarkDataSource(context: Context): BookmarkDataSource {
    private val bookmarkDao = ReaderDatabase.getInstance(context).bookmarkDao()

    override suspend fun add(document: Document, bookmark: Bookmark) {
        bookmarkDao.addBookmark(
            BookmarkEntity(
            documentUri = document.url, page = bookmark.page
        ))
    }

    override suspend fun read(document: Document): List<Bookmark> =
        bookmarkDao.getBookmark(document.url).map { Bookmark(it.id, it.page) }

    override suspend fun remove(document: Document, bookmark: Bookmark) {
        bookmarkDao.removeBookmark(BookmarkEntity(bookmark.id, document.url, bookmark.page))
    }

}