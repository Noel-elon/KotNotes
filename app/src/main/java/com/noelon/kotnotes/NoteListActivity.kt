package com.noelon.kotnotes

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_note_list.*
import kotlinx.android.synthetic.main.content_note_list.*

class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        noteList.adapter =
            ArrayAdapter<NoteInfo>(this, android.R.layout.simple_list_item_1, Datamanager.notes)

        noteList.setOnItemClickListener { parent, view, position, id ->
            val intent2 = Intent(this, MainActivity::class.java)
            intent2.putExtra(extranoteposition, position)
            startActivity(intent2)
        }

    }

    override fun onResume() {
        super.onResume()
        (noteList.adapter as ArrayAdapter<NoteInfo>).notifyDataSetChanged()
    }

}
