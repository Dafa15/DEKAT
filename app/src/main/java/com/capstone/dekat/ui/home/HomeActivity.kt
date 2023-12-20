package com.capstone.dekat.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.capstone.dekat.R
import com.capstone.dekat.databinding.ActivityHomeBinding
import com.capstone.dekat.ui.about.AboutFragment
import com.capstone.dekat.ui.scan.ScanActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavView.background = null
        replaceFragment(HomeFragment())

        binding.bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.about -> replaceFragment(AboutFragment())
            }
            true
        }
        binding.apply {
            fabScan.setOnClickListener {
                Intent(this@HomeActivity, ScanActivity::class.java).also { intent ->
                    startActivity(intent)
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}