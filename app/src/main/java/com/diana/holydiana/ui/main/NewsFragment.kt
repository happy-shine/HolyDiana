package com.diana.holydiana.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.diana.holydiana.R
import com.diana.holydiana.databinding.FragmentNewsBinding
import com.diana.holydiana.util.DataService

class NewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentNewsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)
        val dataService = DataService(requireActivity())
        val list: MutableList<String> = ArrayList()
        dataService.getChinaData {
            for (data in it.newslist[0].news) {
                list.add(data.summary)
            }
            binding.recycleView.adapter = NewsAdapter(list)
            Log.d("DATASOURCE", list.toString())
        }


        return binding.root
    }

}