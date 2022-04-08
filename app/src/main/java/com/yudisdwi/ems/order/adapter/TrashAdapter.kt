package com.yudisdwi.ems.order.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.yudisdwi.ems.R
import com.yudisdwi.ems.order.OrderFragment
import com.yudisdwi.ems.order.model.Trash

class TrashAdapter(
    private val context: OrderFragment,
    private val dataset: List<Trash>,
) : RecyclerView.Adapter<TrashAdapter.ItemViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_type)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_type_trash, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)

        holder.itemView.setOnClickListener {
            holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(dataset[holder.adapterPosition]) }
        }
    }

    override fun getItemCount() = dataset.size

    interface OnItemClickCallback {
        fun onItemClicked(data: Trash)
    }
}
