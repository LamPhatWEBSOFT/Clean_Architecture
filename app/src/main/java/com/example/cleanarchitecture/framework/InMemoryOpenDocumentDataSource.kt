package com.example.cleanarchitecture.framework

import com.example.clean_architecture.data.OpenDocumentDataSource
import com.raywenderlich.android.majesticreader.domain.Document

class InMemoryOpenDocumentDataSource: OpenDocumentDataSource {
    private var openDocument: Document = Document.EMPTY
    override fun setOpenDocument(document: Document) {
        openDocument = document
    }

    override fun getOpenDocument(): Document = openDocument
}