package com.yudisdwi.ems.feeds.data

import com.yudisdwi.ems.R
import com.yudisdwi.ems.feeds.model.Feeds

class DataFeeds() {
    fun loadFeeds(): List<Feeds> {
        return listOf<Feeds>(
            Feeds(R.string.tpt_sampah, R.string.harga, R.drawable.pubin),
            Feeds(R.string.sandal, R.string.harga2, R.drawable.sandal),
        )
    }
}