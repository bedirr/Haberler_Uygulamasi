package com.mucahit_bedir.newsapp.utils

import android.content.Context
import android.content.Intent
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.mucahit_bedir.newsapp.model.Article

// share news
fun shareNews(context: Context?, article: Article){
    val intent = Intent().apply{
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, article.urlToImage)
        putExtra(Intent.EXTRA_STREAM, article.urlToImage)
        putExtra(Intent.EXTRA_TITLE, article.title)
        type="image/*"
    }
    context?.startActivity(Intent.createChooser(intent, "Share News On"))
}
//load image in image view
fun getCircularDrawable(context: Context):CircularProgressDrawable{

    return CircularProgressDrawable(context).apply {
        strokeWidth=8f
        centerRadius=48f
        setTint(context.resources.getColor(R.color.))
    }
}