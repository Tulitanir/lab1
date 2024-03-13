package edu.nechaev.demo.models

import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("book_author")
data class AuthorRef(
        @Column("author")
        val authorId: Long
)
