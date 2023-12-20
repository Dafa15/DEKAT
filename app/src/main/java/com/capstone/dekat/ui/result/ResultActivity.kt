package com.capstone.dekat.ui.result

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.capstone.dekat.R
import com.capstone.dekat.databinding.ActivityResultBinding
import com.capstone.dekat.databinding.ActivityScanBinding
import com.capstone.dekat.ui.detail.DetailActivity
import com.capstone.dekat.ui.home.HomeActivity

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    companion object {
        const val RESULT_NAME = "result_name"
        const val RESULT_IMAGE =  "result_image"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val resultName = intent.getStringExtra(RESULT_NAME)
        val resultImage  = intent.getStringExtra(RESULT_IMAGE)

        Glide.with(this@ResultActivity)
            .load(resultImage)
            .into(binding.ivResult)
        binding.tvResult.text = resultName

        customToolbar()
    }

    private fun customToolbar() {
        binding.apply {
            toolbar.navBack.setOnClickListener {
                val intent = Intent(this@ResultActivity, HomeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
            toolbar.tvToolbarName.text = "Result"
        }
    }
}