package com.yudisdwi.ems.tab

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yudisdwi.ems.feeds.FeedsFragment
import com.yudisdwi.ems.order.OrderFragment
import com.yudisdwi.ems.profile.ProfileFragment

class PagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = OrderFragment()
            1 -> fragment = FeedsFragment()
            2 -> fragment = ProfileFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 3
    }
}