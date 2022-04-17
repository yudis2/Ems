package com.yudisdwi.ems.order

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yudisdwi.ems.R
import com.yudisdwi.ems.databinding.FragmentOrderBinding
import com.yudisdwi.ems.order.adapter.TrashAdapter
import com.yudisdwi.ems.order.data.DataSource
import com.yudisdwi.ems.order.model.Trash

class OrderFragment : Fragment(), OrderFragmentCallback {
    /**
     * Hati-hati dengan kebocoran memori (Memory Leak) disini, jangan lupa meng-override fungsi
     * onDestroy() dan inisialisasi variable _binding dengan null.
     * Kamu bisa mendeteksi suatu kebocoran memori dengan bantuan library LeakCanary.
     */
    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var seekBar: SeekBar

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
        recyclerView.adapter = TrashAdapter(this, myDataset, this)
        recyclerView.setHasFixedSize(true)

        binding.weight.text = getString(R.string.volume, 0)
        binding.price.text = getString(R.string.rupiah, 0)

        /**
         * Hapus baris kode yang tidak digunakan
         */
//        trashAdapter = TrashAdapter(this, myDataset)
//        trashAdapter.setOnItemClickCallback(object : TrashAdapter.OnItemClickCallback{
//            override fun onItemClicked(data: Trash) {
//                showSelectedTrash(data)
//            }
//        })

        seekBar = view.findViewById(R.id.volume)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            /**
             * Usahakan tidak untuk men-suppress kode, agar warning lain yang serupa tidak tertutupi oleh Suppress ini
             */
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, user: Boolean) {
                weight(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }

    /**
     * Untuk menggabungkan string, sebaiknya dipisah antara property dengan variable, seperti:
     * ```
     * val weightStr = "$progress Kg"
     * binding.weight.text = weightStr
     * ```
     */
    private fun weight(progress: Int) {
        binding.weight.text = progress.toString() + " Kg"
    }

    override fun onSelectClick(trash: Trash) {
       val tipeSampah = getString(trash.stringResourceId)
        var harga = 0
            binding.type.text = tipeSampah
            when (tipeSampah) {
                "Plastik" -> harga = 5000
                "Kaca" -> harga = 3000
                "Kertas" -> harga = 2000
                "Baterai" -> harga = 1500
                "Besi" -> harga = 4500
                "Obat" -> harga = 9000
            }
            binding.price.text = harga.toString()
    }

}


