package com.noelon.kotnotes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val context: Context, private val notes: List<NoteInfo>) :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = notes.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.textCourse.text = note.courseInfo?.coursetitle
        holder.textTitle.text = note.noteTitle
        holder.notePosition = position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textCourse = itemView.findViewById<TextView>(R.id.textCourse)
        val textTitle = itemView.findViewById<TextView>(R.id.textTitle)
        var notePosition = 0

        init {

            itemView.setOnClickListener {
                val intent = Intent(context, MainActivity::class.java)
                intent.putExtra(extranoteposition, notePosition)
                context.startActivity(intent)
            }
        }
    }

}

