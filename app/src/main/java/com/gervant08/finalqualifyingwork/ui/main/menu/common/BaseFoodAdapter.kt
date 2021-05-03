package com.gervant08.finalqualifyingwork.ui.main.menu.common

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseFoodAdapter: RecyclerView.Adapter<BaseFoodAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}