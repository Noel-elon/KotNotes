package com.noelon.kotnotes

data class CourseInfo(val coursename: String, val coursetitle: String) {
    override fun toString(): String {
        return coursetitle
    }
}

data class NoteInfo(var courseInfo: CourseInfo, var noteTitle: String, var noteText: String)
