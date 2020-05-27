package com.example.practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AddNote.GetData {
    lateinit var displayNote: DisplayNote // Display fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayNote = display_fragment as DisplayNote // Display fragment
        loadFragment()
    }

    private fun loadFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val addNote = AddNote()
        addNote.getData = this
        fragmentTransaction.add(R.id.fragment_container, addNote)
        fragmentTransaction.commit()
    }

    override fun sendData(title: String, description: String) {
        displayNote.sendData(title, description) // Display fragment
    }
}
