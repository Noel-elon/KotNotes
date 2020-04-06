package com.noelon.kotnotes

class Datamanager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()



    init {
        initializecourses()
    }

    private fun initializecourses(){
        var course = CourseInfo("Android_Intents", "Android programming with intents")
        courses.set(course.coursename, course)

        course = CourseInfo(coursename = "android_async", coursetitle = "Android Async programming and services")
        courses.set(course.coursename, course)

        course = CourseInfo(coursetitle = "Java Fundamnetals", coursename = "java_funds")
        courses.set(course.coursename, course)
    }
}