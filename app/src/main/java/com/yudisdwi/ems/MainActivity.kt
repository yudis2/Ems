package com.yudisdwi.ems

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.yudisdwi.ems.databinding.ActivityMainBinding
import com.yudisdwi.ems.tab.PagerAdapter

class MainActivity : AppCompatActivity() {

//    private lateinit var navController: NavController
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2,
            R.string.tab_text_3
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Hapus baris kode yang tidak digunakan
         */
        // Get the navigation host fragment from this Activity
//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        // Instantiate the navController using the NavHostFragment
//        navController = navHostFragment.navController
        // Make sure actions in the ActionBar get propagated to the NavController
//        setupActionBarWithNavController(navController)

        //tab layout
        val sectionsPagerAdapter = PagerAdapter(this)
        /**
         * Baris di bawah ini, sebenarnya bisa digantikan dengan view binding. Sehingga tidak ada
         * lagi fungsi ```findViewById()``` dan tidak akan terjadi ```NullPointerException``` saat
         * sistem membaca komponen di dalam View.
         *
         * ```
         * binding.viewPager.adapter = sectionsPagerAdapter
         * TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position -> ...
         * ```
         */
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
        supportActionBar?.elevation = 0f
    }
}