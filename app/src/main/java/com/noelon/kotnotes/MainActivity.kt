package com.noelon.kotnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var notePosition = positionnotset

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapterCourses = ArrayAdapter<CourseInfo>(
            this,
            android.R.layout.simple_spinner_item,
            Datamanager.courses.values.toList()
        )
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCourses.adapter = adapterCourses

        notePosition = intent.getIntExtra(extranoteposition, positionnotset)
        if (notePosition != positionnotset)
            displayNotes()
    }

    private fun displayNotes() {
        val note = Datamanager.notes[notePosition]
        noteTitleET.setText(note.noteTitle)
        noteBodyET.setText(note.noteText)

        val courseposition = Datamanager.courses.values.indexOf(note.courseInfo)
        spinnerCourses.setSelection(courseposition)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_next -> {
                when (item.icon) {
                    getDrawable(R.drawable.ic_arrow_back_white_24dp) -> moveBack()

                }
                moveNext()
                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }

    private fun moveBack() {
        --notePosition
        displayNotes()
        invalidateOptionsMenu()

    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        if (notePosition >= Datamanager.notes.lastIndex) {
            val menuItem = menu?.findItem(R.id.action_next)
            if (menuItem != null) {
                menuItem.icon = getDrawable(R.drawable.ic_arrow_back_white_24dp)
            }

        }
        return super.onPrepareOptionsMenu(menu)
    }

    private fun moveNext() {
        ++notePosition
        displayNotes()
        invalidateOptionsMenu()
    }
}
