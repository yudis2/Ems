package com.yudisdwi.ems.order

import com.yudisdwi.ems.order.model.Trash

interface OrderFragmentCallback {
    fun onSelectClick(trash: Trash)
}