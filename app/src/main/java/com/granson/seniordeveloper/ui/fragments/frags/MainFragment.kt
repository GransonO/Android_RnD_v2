package com.granson.seniordeveloper.ui.fragments.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.granson.seniordeveloper.R
import com.granson.seniordeveloper.databinding.FragABinding
import com.granson.seniordeveloper.databinding.MainFragmentBinding

class MainFragment : Fragment(R.layout.main_fragment){

    private val binder: MainFragmentBinding by lazy {
        MainFragmentBinding.inflate(layoutInflater)
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

        val navHostFragment = view.findNavController()

        binder.apply {

            fragABtn.setOnClickListener {

            }

            fragBBtn.setOnClickListener {

            }
        }
    }

}