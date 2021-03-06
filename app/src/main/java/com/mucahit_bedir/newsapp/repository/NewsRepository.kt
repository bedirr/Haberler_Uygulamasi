package com.mucahit_bedir.newsapp.repository

import com.mucahit_bedir.newsapp.repository.service.RetroFitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepository {
    private val newsApi = RetroFitClient.api

    suspend fun getBreakingNews(page: Int) = withContext(Dispatchers.IO) {
        newsApi.getBreakingNews(pageNumber = page)
    }
}
