package com.yudisdwi.ems.order.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Trash (
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
)
