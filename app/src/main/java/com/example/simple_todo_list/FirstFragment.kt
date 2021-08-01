package com.example.simple_todo_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simple_todo_list.adapter.CustomAdapter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var listItem: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adapter: CustomAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        setAdapterRecyclerView(view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun setAdapterRecyclerView(view: View) {
        listItem = view.findViewById(R.id.recyclerViewTasks)

        layoutManager = LinearLayoutManager(context)
        listItem.layoutManager = layoutManager

        adapter = CustomAdapter(MainActivity.arrayList)
        listItem.adapter = adapter
    }
}