package com.capstone.dekat.di

import android.content.Context
import com.capstone.dekat.data.TapisRepository
import com.capstone.dekat.data.remote.retrofit.ApiConfig

object Injection {

    fun provideRepository(context: Context): TapisRepository {
        val apiService = ApiConfig.getApiService()
        return TapisRepository.getInstance(apiService)
    }
}