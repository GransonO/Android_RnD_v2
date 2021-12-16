package com.granson.seniordeveloper.ui.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.granson.seniordeveloper.R
import com.granson.seniordeveloper.databinding.ActivityFragBinding

class FragActivity : AppCompatActivity() {

    private val binder: ActivityFragBinding by lazy {
        ActivityFragBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binder.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.frag_container) as NavHostFragment
        val navController = navHostFragment.navController

        binder.apply {
            mToA.setOnClickListener {
                navController.navigate(R.id.action_main_to_A)
            }
            aToM.setOnClickListener {
                navController.navigate(R.id.action_A_to_main)
            }
            mToB.setOnClickListener {
                navController.navigate(R.id.action_main_to_B)
            }
            bToM.setOnClickListener {
                navController.navigate(R.id.action_B_to_main)
            }
            aToB.setOnClickListener {
                navController.navigate(R.id.action_A_to_B)
            }
            bToA.setOnClickListener {
                navController.navigate(R.id.action_B_to_A)
            }
        }
    }
}