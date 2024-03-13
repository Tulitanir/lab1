package edu.nechaev.demo.repositories

import edu.nechaev.demo.models.Author
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : CrudRepository<Author, Long> {
}