package com.yudisdwi.ems.feeds.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yudisdwi.ems.R
import com.yudisdwi.ems.feeds.FeedsFragment
import com.yudisdwi.ems.feeds.model.Feeds

class FeedsAdapter(
    private val context: FeedsFragment,
    private val dataset: List<Feeds>
) : RecyclerView.Adapter<FeedsAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_name)
        val tvView: TextView = view.findViewById(R.id.item_price)
        val imageView: ImageView = view.findViewById(R.id.iv_feeds)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_feeds, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.FeedsName)
        holder.tvView.text = context.resources.getString(item.PriceFeeds)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    override fun getItemCount() = dataset.size
}