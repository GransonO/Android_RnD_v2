package com.granson.seniordeveloper.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.granson.seniordeveloper.databinding.ActivityMainBinding
import com.granson.seniordeveloper.di.NetworkModule
import com.granson.seniordeveloper.di.StarterModule
import com.granson.seniordeveloper.ui.fragments.FragActivity
import com.granson.seniordeveloper.ui.retrofit.RestActivity
import com.granson.seniordeveloper.utils.Utilities.listInt
import com.granson.seniordeveloper.utils.Utilities.openActivity
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    @NetworkModule.FirstString
    lateinit var string: String

    @Inject
    @NetworkModule.SecondString
    lateinit var string2: String

    @Inject
    @NetworkModule.ThirdString
    lateinit var string3: String

    @Inject
    @StarterModule.AScoped
    lateinit var string4: String

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            str1.text = string
            retroBtn.setOnClickListener {
                openActivity(this@MainActivity, RestActivity::class.java)
            }

            fragsBtn.setOnClickListener {
                openActivity(this@MainActivity, FragActivity::class.java)
            }

        }

    }

    private fun orOperator(num: Int?): Int {
        return num ?: 3
    }

    private fun getListSize(){
        val x = listOf(1,2,3,4,5)
        print("List length ${x.listInt()}")
    }

    private fun getSListSize(){
        val x = listOf("a","b","c")
        print("List length ${x.listInt()}")
    }
}