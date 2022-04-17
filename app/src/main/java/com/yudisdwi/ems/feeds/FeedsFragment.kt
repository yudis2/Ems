package com.yudisdwi.ems.feeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yudisdwi.ems.R
import com.yudisdwi.ems.databinding.FragmentFeedsBinding
import com.yudisdwi.ems.feeds.adapter.FeedsAdapter
import com.yudisdwi.ems.feeds.data.DataFeeds


class FeedsFragment : Fragment() {
    private var _binding: FragmentFeedsBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeedsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myDataset = DataFeeds().loadFeeds()
        /**
         * Bisa digantikan dengan view binding
         * ```
         * recyclerView = binding.rvFeeds
         * ```
         */
        recyclerView = view.findViewById(R.id.rv_feeds)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = FeedsAdapter(this, myDataset)
    }
}