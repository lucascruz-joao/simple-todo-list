package com.example.simple_todo_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.simple_todo_list.model.ToDo
import java.sql.Date
import java.sql.Timestamp
import java.time.Instant

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment(){

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val editTextTitle = view.findViewById<EditText>(R.id.editTextTitle)
        val editTextDescription = view.findViewById<EditText>(R.id.editTextDescription)

        view.findViewById<Button>(R.id.buttonNewTask).setOnClickListener {

            if (editTextTitle.text.toString() != "" || editTextDescription.text.toString() != ""){

                MainActivity.arrayList.add(ToDo(
                    MainActivity.arrayList.size,
                    editTextTitle.text.toString(),
                    editTextDescription.text.toString(),
                    false,
                    Timestamp(Date.from(Instant.now()).time)
                ))

                editTextTitle.setText("")
                editTextDescription.setText("")

                Toast.makeText(context,
                    "Task criada com sucesso!", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(context,
                    "Por favor, preencha pelo menos um dos campos.", Toast.LENGTH_LONG).show()
            }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}