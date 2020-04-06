package com.noelon.kotnotes

class CourseInfo(val coursename: String, val coursetitle: String)

class NoteInfo(var courseInfo: CourseInfo, var noteTitle: String, var noteText: String)