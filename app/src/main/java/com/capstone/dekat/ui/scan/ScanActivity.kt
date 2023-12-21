package com.capstone.dekat.ui.scan

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.capstone.dekat.databinding.ActivityScanBinding
import com.capstone.dekat.ui.result.ResultActivity
import com.capstone.dekat.utils.Camera.getImageUri
import com.capstone.dekat.utils.Camera.reduceFileImage
import com.capstone.dekat.utils.Camera.uriToFile
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody

class ScanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScanBinding
    private var currentImageUri: Uri? = null
    private val viewModel: ScanViewModel by lazy {
        ViewModelProvider(this)[ScanViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGalery.setOnClickListener{startGallery()}
        binding.btnCamera.setOnClickListener{startCamera()}
        binding.btnScan.setOnClickListener {
            if (currentImageUri != null) {
                uploadImage()
            }else {
                AlertDialog.Builder(this@ScanActivity).apply {
                    setTitle("Peringatan!!")
                    setMessage("Masukkan gambar terlebih dahulu!!!")
                    create()
                    show()
                }
            }


        }
        viewModel.isLoading.observe(this) {
            showLoading(it)
        }

        customToolbar()
    }

    private fun customToolbar() {
        binding.apply {
            toolbar.navBack.setOnClickListener {
                onBackPressed()
            }
            toolbar.tvToolbarName.text = ""
        }
    }
    private fun uploadImage() {
        currentImageUri?.let { uri ->
            val imageFile = uriToFile(uri, this).reduceFileImage()
            Log.d("Image File", "showImage: ${imageFile.path}")

            val requestImageFile = imageFile.asRequestBody("image/*".toMediaType())
            val multipartBody = MultipartBody.Part.createFormData(
                "image",
                imageFile.name,
                requestImageFile
            )
            lifecycleScope.launch {
                val uploadResult = viewModel.scanTapis(multipartBody)
                val intent = Intent(this@ScanActivity, ResultActivity::class.java)
                intent.putExtra(ResultActivity.RESULT_IMAGE, uploadResult.tapisImage)
                intent.putExtra(ResultActivity.RESULT_NAME, uploadResult.tapisName)
                intent.putExtra(ResultActivity.RESULT_ID, uploadResult.tapisId)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
                }
            }

    }

    private fun startGallery() {
        launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    private val launcherGallery = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            currentImageUri = uri
            showImage()
        } else {
            Log.d("Photo Picker", "No media selected")
        }
    }

    private fun startCamera() {
        currentImageUri = getImageUri(this)
        launcherIntentCamera.launch(currentImageUri)
    }

    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { isSuccess ->
        if (isSuccess) {
            showImage()
        }
    }

    private fun showImage() {
        currentImageUri?.let {
            Log.d("Image URI", "showImage: $it")
            binding.ivPreview.setImageURI(it)
        }
    }

    private fun showLoading(state: Boolean) { binding.progressBar.visibility = if (state) View.VISIBLE else View.GONE }

}