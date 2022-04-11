package com.mucahit_bedir.newsapp.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("articles")
    var articles: MutableList<Article>,
    @SerializedName("status")
    var status: String?,
    @SerializedName("totalResult")
    var totalResult: Int?
)
