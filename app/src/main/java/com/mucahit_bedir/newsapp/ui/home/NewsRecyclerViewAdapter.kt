package com.mucahit_bedir.newsapp.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.mucahit_bedir.newsapp.R
import com.mucahit_bedir.newsapp.model.Article
import com.mucahit_bedir.newsapp.utils.loadImage

class NewsRecyclerViewAdapter : RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsViewHolder>() {


    private var newsList = arrayListOf<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_view_news, parent, false)
        return NewsViewHolder(v)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        newsList[position].urlToImage?.let { holder.itemImage.loadImage(it) }
        newsList[position].publishedAt?.let { holder.itemPublishedAt.text = it }
        newsList[position].title?.let{holder.itemTitle.text = it}
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Article>) {
        newsList.clear()
        newsList.addAll(list)
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemPublishedAt: TextView

        init {
            itemImage = itemView.findViewById(R.id.news_image_view)
            itemTitle = itemView.findViewById(R.id.title_text_view)
            itemPublishedAt = itemView.findViewById(R.id.published_at_text_view)
        }
    }

}