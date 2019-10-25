package com.example.cleanarchitecture.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class CleanArchitectureViewModel(application: Application, protected  val interactors: Interactors):
    AndroidViewModel(application){
    protected val application: CleanArchitectureApplication = getApplication()
}