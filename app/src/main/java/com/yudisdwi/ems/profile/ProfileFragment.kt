package com.yudisdwi.ems.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yudisdwi.ems.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        /**
         * Bisa di inflate dengan view binding
         */
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
}