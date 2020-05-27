package com.example.practice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class AddNote : Fragment() {
    lateinit var titleEditText: EditText
    lateinit var descriptionEditText: EditText
    lateinit var addButton: Button

    interface GetData {
        fun sendData (title: String, description: String)
    }

    lateinit var getData: GetData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_note, container, false)
        titleEditText = view.findViewById(R.id.edt_title)
        descriptionEditText = view.findViewById(R.id.edt_description)
        addButton = view.findViewById(R.id.btn_add)
        addButton.setOnClickListener {
            getData.sendData(titleEditText.text.toString(), descriptionEditText.text.toString())
        }
        return view
    }

}
