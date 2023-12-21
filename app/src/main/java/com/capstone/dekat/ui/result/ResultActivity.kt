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
import com.capstone.dekat.ui.maps.MapsActivity

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    companion object {
        const val RESULT_NAME = "result_name"
        const val RESULT_IMAGE =  "result_image"
        const val RESULT_ID = "result_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val resultName = intent.getStringExtra(RESULT_NAME)
        val resultImage  = intent.getStringExtra(RESULT_IMAGE)
        val resultId = intent.getStringExtra(RESULT_ID)

        Glide.with(this@ResultActivity)
            .load(resultImage)
            .into(binding.ivResult)
        binding.tvResult.text = resultName

        customToolbar()

        binding.btnMap.setOnClickListener {
            val intent = Intent(this@ResultActivity, MapsActivity::class.java)
            startActivity(intent)
        }
        binding.btnDetail.setOnClickListener {
            val intent = Intent(this@ResultActivity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.TAPIS_ID, resultId)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }

    private fun customToolbar() {
        binding.apply {
            toolbar.navBack.setOnClickListener {
                onBackPressed()
            }
            toolbar.tvToolbarName.text = "Result"
        }
    }
}