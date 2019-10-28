package com.example.cleanarchitecture.Presentation.library

import android.app.Application
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import com.example.clean_architecture.domain.Document
import com.example.cleanarchitecture.framework.CleanArchitectureViewModel
import com.example.cleanarchitecture.framework.Interactors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LibraryViewModel (application: Application, interactors: Interactors):
    CleanArchitectureViewModel(application, interactors){
    val documents: MutableLiveData<List<Document>> = MutableLiveData()

    fun loadDocuments(){
        GlobalScope.launch {
            documents.postValue(interactors.getDocuments())
        }
    }

    fun addDocument(uri: Uri){
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                interactors.addDocument(Document(uri.toString(), "", 0, ""))
            }
            loadDocuments()
        }
    }

    fun setOpenDocument(document: Document){
        interactors.setOpenDocument(document)
    }
}