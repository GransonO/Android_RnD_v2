package com.granson.seniordeveloper.ui.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.granson.seniordeveloper.data.ToDoObject
import com.granson.seniordeveloper.databinding.ActivityRestBinding
import com.granson.seniordeveloper.ui.retrofit.adapters.ToDoAdapter
import com.granson.seniordeveloper.ui.retrofit.logic.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class RestActivity : AppCompatActivity() {

    private val binding: ActivityRestBinding by lazy {
        ActivityRestBinding.inflate(layoutInflater)
    }

    private val todoViewModel: TodoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            button.setOnClickListener {
                progressBar.visibility = View.VISIBLE
                getTodoItems()
            }
        }

    }

    private fun getTodoItems(){
        lifecycleScope.launchWhenStarted {
            todoViewModel.getList().observe(this@RestActivity){
                val recyclerAdapter = it?.let { it1 -> ToDoAdapter(it1, this@RestActivity) }
                binding.apply {
                    recyclerView.adapter = recyclerAdapter
                    recyclerView.layoutManager = LinearLayoutManager(this@RestActivity)
                    progressBar.visibility = View.GONE
                }
            }
        }
    }

    private fun getTodoNonHilt(){
        lifecycleScope.launchWhenStarted {
            todoViewModel.getTodoNonHilt().observe(this@RestActivity){
                val recyclerAdapter = it?.let { it1 -> ToDoAdapter(it1, this@RestActivity) }
                binding.apply {
                    recyclerView.adapter = recyclerAdapter
                    recyclerView.layoutManager = LinearLayoutManager(this@RestActivity)
                    progressBar.visibility = View.GONE
                }
            }
        }
    }
}