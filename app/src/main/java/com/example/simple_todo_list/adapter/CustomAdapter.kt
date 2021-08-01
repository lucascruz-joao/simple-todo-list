package com.example.simple_todo_list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simple_todo_list.R
import com.example.simple_todo_list.model.ToDo

class CustomAdapter(private val dataSet: ArrayList<ToDo>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    //TODO necessário fazer correção do recyclerView repetindo itens
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var textViewTaskTitle: TextView = view.findViewById(R.id.textViewTaskTitle)
        var textViewTaskDescription: TextView = view.findViewById(R.id.textViewTaskDescription)
        var checkBoxStatusTask: CheckBox = view.findViewById(R.id.statusTask)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.text_row_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewTaskTitle.text = dataSet[position].title
        holder.textViewTaskDescription.text = dataSet[position].description
        holder.checkBoxStatusTask.isChecked = dataSet[position].status
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


}