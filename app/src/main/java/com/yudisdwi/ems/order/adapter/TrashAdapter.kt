package com.yudisdwi.ems.order.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yudisdwi.ems.R
import com.yudisdwi.ems.order.OrderFragment
import com.yudisdwi.ems.order.OrderFragmentCallback
import com.yudisdwi.ems.order.model.Trash

class TrashAdapter(
    private val context: OrderFragment,
    private val dataset: List<Trash>,
    private var callback: OrderFragmentCallback
) : RecyclerView.Adapter<TrashAdapter.ItemViewHolder>() {

    /**
     * Klausa "private val" dapat dihapus pada constructor karena variable view tidak pernah
     * digunakan sebagai property.
     */
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_type)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        /**
         * Sebaiknya implementasikan view binding di adapter RecyclerView juga.
         * ```
         * val binding = ItemTypeTrash.inflate(LayoutInflater.from(parent.context), parent, false)
         * return ItemViewHolder(binding.root)
         * ```
         */
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_type_trash, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)

        holder.itemView.setOnClickListener { callback.onSelectClick(dataset[holder.adapterPosition]) }
    }

    override fun getItemCount() = dataset.size
    
}
