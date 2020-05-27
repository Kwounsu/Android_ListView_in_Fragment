package com.example.practice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Adapter(context: Context, private val dataSource: ArrayList<Note>):BaseAdapter() {
    private var layoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val listView: View
        val viewHolder: ViewHolder

        val note = getItem(position)

        if (convertView == null) {
            listView = layoutInflater.inflate(R.layout.listview_layout, parent, false)
            viewHolder = ViewHolder()
            viewHolder.noteTitle = listView.findViewById(R.id.txt_title)
            viewHolder.noteDescription = listView.findViewById(R.id.txt_description)
            listView.tag = viewHolder
        } else {
            listView = convertView
            viewHolder = listView.tag as ViewHolder
        }

        viewHolder.noteTitle.text = note.mTitle
        viewHolder.noteDescription.text = note.mDescription

        return listView
    }

    private class ViewHolder() {
        lateinit var noteTitle: TextView
        lateinit var noteDescription: TextView
    }

    override fun getItem(position: Int): Note {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }
}