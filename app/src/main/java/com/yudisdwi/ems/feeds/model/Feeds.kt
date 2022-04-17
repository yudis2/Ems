package com.yudisdwi.ems.feeds.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Sebaiknya penulisan nama variable gunakan format camelCase
 */
data class Feeds (
    @StringRes val FeedsName: Int,
    @StringRes val PriceFeeds: Int,
    @DrawableRes val imageResourceId: Int,
)