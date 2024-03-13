package edu.nechaev.demo.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.sql.Date

@Table
data class Author(
        @Id val id: Long,
        var name: String,
        var surname: String,
        var patrymonic: String?,
        var dateOfBirth: Date
)
