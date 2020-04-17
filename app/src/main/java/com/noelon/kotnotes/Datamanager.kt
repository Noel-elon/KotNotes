package com.noelon.kotnotes

object Datamanager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()


    init {
        initializecourses()
        initializenotes()
    }

    fun addNote(course: CourseInfo, noteTitle: String, noteText: String): Int {
        val note = NoteInfo(course, noteTitle, noteText)
        notes.add(note)
        val index = Datamanager.notes.indexOf(note)

        return index
    }

    private fun initializecourses() {
        var course = CourseInfo("Android_Intents", "Android programming with intents")
        courses.set(course.coursename, course)

        course = CourseInfo(
            coursename = "android_async",
            coursetitle = "Android Async programming and services"
        )
        courses.set(course.coursename, course)

        course = CourseInfo(coursetitle = "Java Fundamentals", coursename = "java_funds")
        courses.set(course.coursename, course)
    }



     fun initializenotes() {
        var noteInfo = NoteInfo(
            CourseInfo("My name", "Noel"),
            "This is a sample note",
            "Hey There i told you that this s a sample note"
        )
        notes.add(noteInfo)

        noteInfo = NoteInfo(noteTitle = "Joel", noteText = "This is the name of my junior brother")
        notes.add(noteInfo)
    }
}