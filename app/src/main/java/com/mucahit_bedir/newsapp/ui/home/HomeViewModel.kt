package com.mucahit_bedir.newsapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mucahit_bedir.newsapp.model.Article
import com.mucahit_bedir.newsapp.repository.NewsRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val newsRepository = NewsRepository()

    private val _newsListLiveData = MutableLiveData<List<Article>>()
    val newsListLiveData: LiveData<List<Article>> = _newsListLiveData


    fun getBreakingNews() {
        viewModelScope.launch {
            try {
                val response = newsRepository.getBreakingNews(1)
                _newsListLiveData.postValue(response.articles)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}