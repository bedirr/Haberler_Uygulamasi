package com.mucahit_bedir.newsapp.repository.service

import com.mucahit_bedir.newsapp.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroFitClient {
    companion object {
        private val retroFitClient by lazy {

            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val api by lazy {
            retroFitClient.create(NewsApi::class.java)
        }
    }
}