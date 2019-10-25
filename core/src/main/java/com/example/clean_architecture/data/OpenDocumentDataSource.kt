package com.example.clean_architecture.data

import com.raywenderlich.android.majesticreader.domain.Document

interface OpenDocumentDataSource {
    fun setOpenDocument(document: Document)
    fun getOpenDocument(): Document
}