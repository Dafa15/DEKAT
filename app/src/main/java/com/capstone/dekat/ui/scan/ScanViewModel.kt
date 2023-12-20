package com.capstone.dekat.ui.scan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.dekat.data.remote.response.ScanTapisResponse
import com.capstone.dekat.data.remote.retrofit.ApiConfig
import okhttp3.MultipartBody

class ScanViewModel: ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    suspend fun scanTapis(file: MultipartBody.Part): ScanTapisResponse {
        _isLoading.value = true
        val client = ApiConfig.getApiService().scanTapis(file)
        _isLoading.value = false
        return client
    }
}