package com.example.wsrfood.ui.heart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wsrfood.R

class HeartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_heart, container, false)


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}