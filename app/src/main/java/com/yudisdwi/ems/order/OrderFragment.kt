package com.yudisdwi.ems.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yudisdwi.ems.R
import com.yudisdwi.ems.databinding.FragmentOrderBinding
import com.yudisdwi.ems.order.adapter.TrashAdapter
import com.yudisdwi.ems.order.data.DataSource
import com.yudisdwi.ems.order.model.Trash

class OrderFragment : Fragment() {
    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var seekBar: SeekBar
    private lateinit var trashAdapter: TrashAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // initialize data from adapter
        val myDataset = DataSource().loadTrash()
        // initialize view recycle view
        recyclerView = view.findViewById(R.id.rv_type)
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        recyclerView.adapter = trashAdapter
        recyclerView.setHasFixedSize(true)

        binding.weight.text = getString(R.string.volume, 0)
        binding.price.text = getString(R.string.rupiah, 0)

        trashAdapter = TrashAdapter(this, myDataset)
        trashAdapter.setOnItemClickCallback(object : TrashAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Trash) {
                showSelectedTrash(data)
            }
        })

        seekBar = view.findViewById(R.id.volume)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, user: Boolean) {
                binding.weight.text = progress.toString() + " Kg"
                binding.price.text = "20.000"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }

    private fun showSelectedTrash(data : Trash) {
        Toast.makeText(activity, "Kamu memilih " + data.stringResourceId, Toast.LENGTH_SHORT).show()
    }
}


