package com.example.cleanarchitecture.framework

import android.app.Application
import com.example.clean_architecture.data.BookmarkRepository
import com.example.clean_architecture.data.DocumentRepository
import com.example.clean_architecture.interactors.*

class CleanArchitectureApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        val bookmarkRepository = BookmarkRepository(RoomBookmarkDataSource(this))
        val documentRepository = DocumentRepository(RoomDocumentDataSource(this), InMemoryOpenDocumentDataSource())

        CleanArchitectureViewModelFactory.inject(this,
            Interactors(
                AddBookmark(bookmarkRepository),
                GetBookmarks(bookmarkRepository),
                RemoveBookmark(bookmarkRepository),
                AddDocument(documentRepository),
                GetDocuments(documentRepository),
                RemoveDocument(documentRepository),
                SetOpenDocument(documentRepository),
                GetOpenDocument(documentRepository)
                )
        )

    }
}