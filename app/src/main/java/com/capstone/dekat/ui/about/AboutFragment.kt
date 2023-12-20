package com.capstone.dekat.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.capstone.dekat.R
import com.capstone.dekat.databinding.FragmentAboutBinding


class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentAboutBinding.inflate(inflater, container, false) // Inisialisasi binding di sini

        customToolbar()
        return binding.root
    }

    private fun customToolbar() {
        binding.apply {
            toolbar.navBack.visibility = View.GONE
            toolbar.tvToolbarName.setText(R.string.about)
        }
    }
}
