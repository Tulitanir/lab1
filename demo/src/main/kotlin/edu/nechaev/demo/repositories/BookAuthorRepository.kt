package edu.nechaev.demo.repositories

import edu.nechaev.demo.models.BookAuthor
import org.springframework.data.repository.CrudRepository

interface BookAuthorRepository : CrudRepository<BookAuthor, Long> {
}