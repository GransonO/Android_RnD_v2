package com.granson.seniordeveloper.ui.fragments.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.granson.seniordeveloper.R
import com.granson.seniordeveloper.databinding.FragBBinding

class FragmentB : Fragment(R.layout.frag_b){

    private val binder: FragBBinding by lazy {
        FragBBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binder.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binder
            .apply {
                homeB.text = "This is Fragment B"
            }
    }

}