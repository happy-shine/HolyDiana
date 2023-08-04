package com.diana.holydiana.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.diana.holydiana.R
import com.diana.holydiana.databinding.FragmentChinaBinding
import com.diana.holydiana.util.DataService
import com.diana.holydiana.util.DataService.Companion.setTextColor


class ChinaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataService = DataService(requireActivity())
        val binding: FragmentChinaBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_china, container, false)

        dataService.getChinaData() {
            setTextColor(
                it.newslist[0].desc.currentConfirmedIncr,
                it.newslist[0].desc.currentConfirmedCount,
                "现存确诊",
                binding.confirmedTextView
            )
            setTextColor(
                it.newslist[0].desc.suspectedIncr,
                it.newslist[0].desc.suspectedCount,
                "境外输入",
                binding.importFromAbroadTextView
            )
            setTextColor(
                it.newslist[0].desc.seriousIncr,
                it.newslist[0].desc.seriousCount,
                "现存无症状",
                binding.noSymptomsTextView
            )
            setTextColor(
                it.newslist[0].desc.confirmedIncr,
                it.newslist[0].desc.confirmedCount,
                "累计确诊",
                binding.totalConfirmedTextView
            )
            setTextColor(
                it.newslist[0].desc.deadIncr,
                it.newslist[0].desc.deadCount,
                "累计死亡",
                binding.totalDeadTextView
            )
            setTextColor(
                it.newslist[0].desc.curedIncr,
                it.newslist[0].desc.curedCount,
                "累计治愈",
                binding.totalHealedTextView
            )
        }
        return binding.root
    }


}