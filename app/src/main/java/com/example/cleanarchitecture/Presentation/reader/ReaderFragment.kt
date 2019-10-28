package com.example.cleanarchitecture.Presentation.reader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clean_architecture.domain.Document
import com.example.cleanarchitecture.R

class ReaderFragment: Fragment() {
    companion object{
        fun newInstance(document: Document) = ReaderFragment().apply {
            arguments = ReaderViewModel.createArg(document)
        }
    }

    private lateinit var viewModel: ReaderViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reader, container, false)
    }


}