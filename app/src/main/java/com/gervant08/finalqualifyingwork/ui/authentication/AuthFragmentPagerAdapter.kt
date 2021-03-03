package com.gervant08.finalqualifyingwork.ui.authentication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class AuthFragmentPagerAdapter(
    fragmentsList: ArrayList<Fragment>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val authFragmentsList = fragmentsList

    override fun getItemCount(): Int {
        return authFragmentsList.size
    }

    override fun createFragment(position: Int): Fragment = authFragmentsList[position]
}