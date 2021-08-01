package com.example.simple_todo_list.model

class ToDo {
    var id: Int = 0
    lateinit var title: String
    lateinit var description: String
    var status: Boolean = false
    lateinit var time : java.sql.Timestamp

    constructor()

    constructor(id: Int, title: String, description: String, status: Boolean, time: java.sql.Timestamp) {
        this.id = id
        this.title = title
        this.description = description
        this.status = status
        this.time = time
    }
}