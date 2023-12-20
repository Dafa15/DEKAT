package com.capstone.dekat.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.capstone.dekat.databinding.ActivityDetailBinding
import com.capstone.dekat.ui.maps.MapsActivity
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {
    companion object {
        const val  TAPIS_ID = "tapis_id"
    }

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this).get(DetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val tapisId = intent.getStringExtra(TAPIS_ID)

        viewModel.isLoading.observe(this) {
            showLoading(it)
        }

        lifecycleScope.launch {
            if (tapisId != null) {
                viewModel.getDetailTapis(tapisId).apply {
                    Glide.with(this@DetailActivity)
                        .load(thumbnail)
                        .into(binding.imgItemPhoto)
                    binding.tvItemName.text = name
                    binding.tvItemKegunaan.text = utility
                    binding.tvItemMakna.text = signification
                    binding.tvItemDescription.text = description
                }
            }
        }

        binding.apply {
            fabBack.setOnClickListener {
                onBackPressed()
            }
            button.setOnClickListener{
                val intent = Intent(this@DetailActivity, MapsActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun showLoading(state: Boolean) { binding.progressBar.visibility = if (state) View.VISIBLE else View.GONE }

}