package com.noelon.kotnotes

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CreateNewNoteTest {

    @Rule
    @JvmField
    val noteListactivity = (NoteListActivity::class.java)

    @Test
    fun createNewNote() {
        val noteTitle = "Test note title"
        val noteText = "Note text body here please"
        val course = Datamanager.courses["android_async"]

        onView(withId(R.id.fab)).perform(click())


        onView(withId(R.id.spinnerCourses)).perform(click())
        onData(allOf(instanceOf(CourseInfo::class.java), equalTo(course))).perform(click())
        onView(withId(R.id.noteTitleET)).perform(typeText(noteTitle))
        onView(withId(R.id.noteBodyET)).perform(typeText(noteText))

        Espresso.pressBack()
        Espresso.pressBack()

        val newNote = Datamanager.notes.last()
        assertEquals(course, newNote.courseInfo)
        assertEquals(noteTitle, newNote.noteTitle)

    }
}