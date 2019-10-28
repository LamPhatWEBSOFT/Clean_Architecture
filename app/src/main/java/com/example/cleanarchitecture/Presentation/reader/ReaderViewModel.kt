package com.example.cleanarchitecture.Presentation.reader

import android.app.Application
import android.graphics.pdf.PdfRenderer
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.clean_architecture.domain.Document
import com.example.cleanarchitecture.framework.CleanArchitectureViewModel
import com.example.cleanarchitecture.framework.Interactors
import com.raywenderlich.android.majesticreader.domain.Bookmark
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ReaderViewModel (application: Application, interactors: Interactors): CleanArchitectureViewModel(application, interactors){

    companion object{
        private const val DOCUMENT_ARG ="document"
        fun createArg(document: Document) = bundleOf(DOCUMENT_ARG to document)

    }
    val document = MutableLiveData<Document>()
    val bookmarks = MediatorLiveData<List<Bookmark>>().apply {
        addSource(document){
            GlobalScope.launch { postValue(interactors.getBookmarks(it)) }
        }
    }
    val currentPage = MediatorLiveData<PdfRenderer.Page>()

    fun loadArguments(arguments: Bundle?){
        if (arguments == null){
            return
        }
        currentPage.apply {
            addSource(ren)
        }
    }

    fun toggleInLibrary(){
        val document = document.value ?: return
        GlobalScope.launch {  }
    }
}