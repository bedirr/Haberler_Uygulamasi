package com.mucahit_bedir.newsapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mucahit_bedir.newsapp.R
import com.mucahit_bedir.newsapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {
    private val adapter: NewsRecyclerViewAdapter by lazy {
        NewsRecyclerViewAdapter()
    }

    lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        binding.newsRecyclerView.adapter = adapter
    }


}