package com.example.clean_architecture.data

import com.raywenderlich.android.majesticreader.domain.Document

interface DocumentDataSource {
    suspend fun add(document: Document)
    suspend fun readAll(): List<Document>
    suspend fun remove(document: Document)
}