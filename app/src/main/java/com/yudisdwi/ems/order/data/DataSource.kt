package com.yudisdwi.ems.order.data

import com.yudisdwi.ems.R
import com.yudisdwi.ems.order.model.Trash

class DataSource() {

    fun loadTrash(): List<Trash> {
        return listOf<Trash>(
            Trash(R.string.plastik, R.drawable.plastic),
            Trash(R.string.kaca, R.drawable.glass),
            Trash(R.string.kertas, R.drawable.papper),
            Trash(R.string.baterai, R.drawable.battery),
            Trash(R.string.besi, R.drawable.metal),
            Trash(R.string.obat, R.drawable.medicine))
    }
}
