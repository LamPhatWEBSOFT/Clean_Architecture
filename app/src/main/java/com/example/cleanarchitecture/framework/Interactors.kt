package com.example.cleanarchitecture.framework

import com.example.clean_architecture.interactors.*

class Interactors (
    val addBookmark: AddBookmark,
    val getBookmarks: GetBookmarks,
    val deleteBookmark: RemoveBookmark,
    val addDocument: AddDocument,
    val getDocuments: GetDocuments,
    val removeDocument: RemoveDocument,
    val setOpenDocument: SetOpenDocument,
    val getOpenDocument: GetOpenDocument
)