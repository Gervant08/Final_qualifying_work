package com.gervant08.finalqualifyingwork.ui.main.menu.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser

abstract class BaseFoodFragment<VM: ViewModel>(private val fragmentId: Int) : Fragment(fragmentId) {

    protected lateinit var viewModel: VM
//    protected lateinit var adapter: BaseFoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val factory = ViewModelFactory(getJsonMenuParser())
        viewModel = ViewModelProvider(this, factory).get(getViewModel())
        return inflater.inflate(fragmentId, container, false)
    }

    abstract fun initListInAdapter()
    abstract fun getJsonMenuParser(): JsonMenuParser
    abstract fun getViewModel(): Class<VM>


}
