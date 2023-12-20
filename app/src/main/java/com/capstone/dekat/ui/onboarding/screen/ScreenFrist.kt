package com.capstone.dekat.ui.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.capstone.dekat.R

class ScreenFrist : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_screen_frist, container, false)

        val viewPager =  activity?.findViewById<ViewPager2>(R.id.viewPager)

        view.setOnClickListener {
            viewPager?.currentItem = 1
        }

        return view
    }

}