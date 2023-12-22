package com.capstone.dekat.ui.maps

import androidx.lifecycle.ViewModel
import com.capstone.dekat.data.remote.response.StoreTapisResponseItem
import com.capstone.dekat.data.remote.retrofit.ApiConfig

class MapsViewModel: ViewModel() {

    suspend fun getLocation(): List<StoreTapisResponseItem> {
        val client = ApiConfig.getApiService().getStoreLocation()

        return client
    }
}



