package com.example.clean_architecture.interactors

import com.example.clean_architecture.data.BookmarkRepository
import com.raywenderlich.android.majesticreader.domain.Document

class GetBookmarks (private val bookmarkRepository: BookmarkRepository){
    suspend operator fun invoke(document: Document) = bookmarkRepository.getBookmarks(document)
}