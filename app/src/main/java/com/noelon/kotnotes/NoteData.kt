package com.noelon.kotnotes

class CourseInfo(val coursename: String, val coursetitle: String) {
    override fun toString(): String {
        return coursetitle
    }
}

class NoteInfo(var courseInfo: CourseInfo, var noteTitle: String, var noteText: String)