package com.diana.holydiana.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.diana.holydiana.R
import com.diana.holydiana.databinding.FragmentForeignBinding
import com.diana.holydiana.util.DataService
import com.diana.holydiana.util.DataService.Companion.setTextColor


class ForeignFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentForeignBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_foreign, container, false)
        val dataService = DataService(requireActivity())
        dataService.getAbroadData {
            setTextColor(
                it.newslist[0].currentConfirmedCount,
                "现存确诊",
                binding.confirmedTextView2
            )
            setTextColor(
                it.newslist[0].confirmedCount,
                "累计确诊",
                binding.importFromAbroadTextView2
            )
            setTextColor(
                it.newslist[0].deadCount,
                "累计死亡",
                binding.noSymptomsTextView2
            )

        }

        return binding.root
    }

}