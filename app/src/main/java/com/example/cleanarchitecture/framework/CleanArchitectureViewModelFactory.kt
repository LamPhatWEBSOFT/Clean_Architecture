package com.example.cleanarchitecture.framework

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object CleanArchitectureViewModelFactory : ViewModelProvider.Factory{
    lateinit var application: Application
    lateinit var  dependencies: Interactors
    fun inject(application: Application, dependencies: Interactors){
        CleanArchitectureViewModelFactory.application = application
        CleanArchitectureViewModelFactory.dependencies = dependencies
    }
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (CleanArchitectureViewModel::class.java.isAssignableFrom(modelClass)){
            return modelClass.getConstructor(Application::class.java, Interactors::class.java)
                .newInstance(application, dependencies)
        }else{
            throw IllegalStateException("ViewModel must extend MajesticViewModel")
        }
    }
}