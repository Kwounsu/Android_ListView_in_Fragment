package com.example.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment

class DisplayNote : Fragment() {
    lateinit var listView: ListView
    lateinit var title: String
    lateinit var description: String
    lateinit var adapter: Adapter
    private val notes: ArrayList<Note> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_display_note, container, false)

        listView = view.findViewById(R.id.lv)
        val context = activity!!.baseContext
        adapter = Adapter(context, notes)
        listView.adapter = adapter

        return view
    }

    fun sendData(title:String,description:String) {
        this.title = title
        this.description = description
        notes.add(Note(title,description))
        adapter.notifyDataSetChanged()
    }

}
