package com.example.kotlinintro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinintro.databinding.FragmentBlank2Binding
import com.example.kotlinintro.databinding.FragmentBlankBinding

class BlankFragment2 : Fragment() {

    // val binding = FragmentBlank2Binding.inflate(layoutInflater)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank2, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}