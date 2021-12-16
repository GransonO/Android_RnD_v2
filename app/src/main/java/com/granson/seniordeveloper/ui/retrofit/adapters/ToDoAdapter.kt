package com.granson.seniordeveloper.ui.retrofit.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.granson.seniordeveloper.R
import com.granson.seniordeveloper.data.ToDoObject
import com.granson.seniordeveloper.databinding.TodoItemBinding

class ToDoAdapter(
        var items: List<ToDoObject>,
        var context: Context
) : RecyclerView.Adapter<ToDoAdapter.TodoViewHolder>(){

    inner class TodoViewHolder(private val binding: TodoItemBinding): RecyclerView.ViewHolder(binding.root){

        fun binder(item: ToDoObject) {
            binding.itemBody.text = item.title
            binding.itemId.text = item.id.toString()
            binding.itemStatus.text = "Completed: ${item.completed}"
        }

        fun clicker(item: ToDoObject){
            binding.root.setOnClickListener {
                Toast.makeText(context, item.title, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binder(items[position])
        holder.clicker(items[position])
    }

    override fun getItemCount(): Int {
        // Get the size of the list items
        return items.size
    }

}
