package com.example.clean_architecture.interactors

import com.example.clean_architecture.data.DocumentRepository

class GetDocuments(private val documentRepository: DocumentRepository) {
    suspend operator fun invoke() =documentRepository.getDocuments()
}