package com.gervant08.finalqualifyingwork.ui.main.menu

import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.MenuCategory
import com.gervant08.finalqualifyingwork.ui.main.menu.common.BaseFoodAdapter

class MenuAdapter(listener: OnItemClickListener<MenuCategory>) : BaseFoodAdapter<MenuCategory>(listener = listener) {

    override fun getLayoutId(position: Int, obj: MenuCategory): Int = R.layout.item_menu_category

}