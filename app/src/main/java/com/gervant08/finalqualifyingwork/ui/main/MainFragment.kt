package com.gervant08.finalqualifyingwork.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.gervant08.finalqualifyingwork.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var mainBottomNavigationView: BottomNavigationView
    private val host by lazy { NavHostFragment.create(R.navigation.main_screen_navigation) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentManager?.beginTransaction()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}