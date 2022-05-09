package com.mucahit_bedir.newsapp.repository.service

import android.provider.SyncStateContract
import com.mucahit_bedir.newsapp.model.NewsResponse
import com.mucahit_bedir.newsapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country") country: String = "tr",
        @Query("page") pageNumber: Int,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): NewsResponse

    @GET("v2/everything")
    suspend fun getSearchNews(
        @Query("q") searchQuery: String,
        @Query("page") pageNumber: Int,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): NewsResponse
}