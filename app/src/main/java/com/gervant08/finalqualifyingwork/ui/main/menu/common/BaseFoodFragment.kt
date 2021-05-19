package com.gervant08.finalqualifyingwork.ui.main.menu.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser

abstract class BaseFoodFragment<VM: ViewModel, IT: Any>(private val fragmentId: Int) : Fragment(fragmentId) {

    protected lateinit var viewModel: VM
    protected lateinit var adapter: BaseFoodAdapter<IT>
    protected lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory(getJsonMenuParser())
        viewModel = ViewModelProvider(this, factory).get(getViewModel())
        initAdapter()
        recyclerView = view.findViewById(getRecyclerId())
        recyclerView.adapter = adapter
        initListInAdapter()
    }

    abstract fun getJsonMenuParser(): JsonMenuParser
    abstract fun getViewModel(): Class<VM>
    abstract fun getRecyclerId(): Int
    abstract fun initListInAdapter()
    abstract fun initAdapter()


}
