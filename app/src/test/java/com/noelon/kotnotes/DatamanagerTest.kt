package com.noelon.kotnotes

import org.junit.Test

import org.junit.Assert.*

class DatamanagerTest {

    @Test
    fun addNote() {
        val course = Datamanager.courses.get("android_async")!!
        val noteTitle = "This is a short note"
        val noteText = "This is the body of the note"


        val index = Datamanager.addNote(course, noteTitle, noteText)
        val note = Datamanager.notes[index]

        assertEquals(course, note.courseInfo)
        assertEquals(noteTitle, note.noteTitle)
        assertEquals(noteText, note.noteText)


    }
}