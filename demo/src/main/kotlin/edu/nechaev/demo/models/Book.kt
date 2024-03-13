package edu.nechaev.demo.models

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.ReadOnlyProperty
import org.springframework.data.relational.core.mapping.MappedCollection
import org.springframework.data.relational.core.mapping.Table
import java.sql.Date

@Table
data class Book(
        @Id val id: Long,
        var title: String,
        var yearOfPublication: Date,
        @MappedCollection(keyColumn = "book")
        @ReadOnlyProperty
        var authors: MutableList<AuthorRef> = mutableListOf()
)