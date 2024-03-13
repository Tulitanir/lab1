package edu.nechaev.demo.repositories

import edu.nechaev.demo.models.Book
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.sql.Date

@Repository
interface BookRepository : CrudRepository<Book, Long> {
}