package com.example.cleanarchitecture.framework

import android.content.Context
import com.example.clean_architecture.data.DocumentDataSource
import com.example.cleanarchitecture.framework.db.DocumentEntity
import com.example.cleanarchitecture.framework.db.ReaderDatabase
import com.raywenderlich.android.majesticreader.domain.Document

class RoomDocumentDataSource(val context: Context): DocumentDataSource {
    private val documentDao = ReaderDatabase.getInstance(context).documentDao()
    override suspend fun add(document: Document) {
        val detail = FileUtil.getDocumentDetails(context, document.url)
        documentDao.addDocument(DocumentEntity(document.url, detail.name, detail.size, detail.thumbnail))
    }

    override suspend fun readAll(): List<Document> = documentDao.getDocument().map {
        Document(it.uri,it.name, it.size, it.thumbnail)
    }

    override suspend fun remove(document: Document) = documentDao.removeDocument(
        DocumentEntity(document.url, document.name, document.size, document.thumbnail)
    )
}