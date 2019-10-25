package com.example.clean_architecture.interactors

import com.example.clean_architecture.data.DocumentRepository
import com.raywenderlich.android.majesticreader.domain.Document

class RemoveDocument(private val documentRepository: DocumentRepository) {
    suspend operator fun invoke(document: Document) =
        documentRepository.removeDocument(document)
}