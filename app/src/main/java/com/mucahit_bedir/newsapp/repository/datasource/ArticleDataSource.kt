package com.mucahit_bedir.newsapp.repository.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.bumptech.glide.load.engine.Resource
import com.mucahit_bedir.newsapp.model.Article
import com.mucahit_bedir.newsapp.model.NewsResponse
import com.mucahit_bedir.newsapp.repository.service.RetroFitClient
import com.mucahit_bedir.newsapp.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

class ArticleDataSource(val scope: CoroutineScope) : PageKeyedDataSource<Int, Article>() {

    //for breaking news
    val breakingNews: MutableLiveData<MutableList<Article>> = MutableLiveData()
    var breakingPageNumber = 1
    var breakingNewsResponse: NewsResponse? = null

    //for search news
    val searchNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var searchPageNumber = 1
    var searchNewsResponse: NewsResponse? = null

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Article>
    ) {
        scope.launch {
            try {
                val response= RetroFitClient.api.getBreakingNews("tr",1, Constants.API_KEY)
                when{
                    response.isSuccessful->{
                        response.body()?.articles?.let {
                            breakingNews.postValue(it)
                            callback.onResult(it, null, 2)
                        }
                    }
                }
            }catch (exception:Exception){
                Log.e("DataSource:: ", exception.message.toString())
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Article>) {
        TODO("Not yet implemented")
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Article>) {
        try {
            scope.launch {
                val response = RetroFitClient.api.getBreakingNews(
                    "tr",
                    params.requestedLoadSize,
                    Constants.API_KEY
                )
                when {
                    response.isSuccessful -> {
                        response.body()?.articles?.let {

                            callback.onResult(it, params.key + 1)
                        }
                    }
                }
            }
        }catch (exception:Exception){
            Log.e("DataSource:: ", exception.message.toString())
        }
    }
}