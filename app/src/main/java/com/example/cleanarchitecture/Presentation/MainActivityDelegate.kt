package com.example.cleanarchitecture.Presentation

import com.example.clean_architecture.domain.Document

interface MainActivityDelegate {
    fun openDocument(document: Document)
}