package com.diana.holydiana.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.diana.holydiana.databinding.FragmentMainBinding

class PlaceholderFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): Fragment =
            when (sectionNumber) {
                0 -> ChinaFragment()
                1 -> ForeignFragment()
                else -> NewsFragment()
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}