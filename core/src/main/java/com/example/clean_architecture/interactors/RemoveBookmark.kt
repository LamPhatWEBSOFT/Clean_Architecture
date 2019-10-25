package com.example.clean_architecture.interactors

import com.example.clean_architecture.data.BookmarkRepository
import com.raywenderlich.android.majesticreader.domain.Bookmark
import com.raywenderlich.android.majesticreader.domain.Document

class RemoveBookmark (private val bookmarkRepository: BookmarkRepository){
    suspend operator fun invoke(document: Document, bookmark: Bookmark) =
        bookmarkRepository.removeBookmark(document, bookmark)
}