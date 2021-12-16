package com.granson.seniordeveloper.ui.fragments.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.granson.seniordeveloper.R
import com.granson.seniordeveloper.databinding.FragABinding

class FragmentA : Fragment(R.layout.frag_a){

    private val binder: FragABinding by lazy {
        FragABinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binder.apply {
            homeTxt.text="This is Fragment A"
        }
    }

}