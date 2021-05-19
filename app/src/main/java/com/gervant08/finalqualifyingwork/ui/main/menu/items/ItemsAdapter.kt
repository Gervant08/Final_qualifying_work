package com.gervant08.finalqualifyingwork.ui.main.menu.items

import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.MenuItem
import com.gervant08.finalqualifyingwork.ui.main.menu.common.BaseFoodAdapter

class ItemsAdapter(listener: OnItemClickListener<MenuItem>): BaseFoodAdapter<MenuItem>(listener = listener) {

    override fun getLayoutId(position: Int, obj: MenuItem): Int =
        R.layout.item_menu_item

}