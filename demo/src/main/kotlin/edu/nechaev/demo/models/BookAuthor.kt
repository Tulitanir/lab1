package edu.nechaev.demo.models

import org.springframework.data.annotation.Id

data class BookAuthor (
        @Id val id: Long?,
        val book: Long,
        val author: Long
)