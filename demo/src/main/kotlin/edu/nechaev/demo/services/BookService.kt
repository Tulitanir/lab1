package edu.nechaev.demo.services

import edu.nechaev.demo.models.Book
import edu.nechaev.demo.models.BookAuthor
import edu.nechaev.demo.repositories.BookAuthorRepository
import edu.nechaev.demo.repositories.BookRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class BookService(val repo: BookRepository, val repo2: BookAuthorRepository) {
    fun findBooks(): List<Book> = repo.findAll().toList()
    fun findById(id: Long): Book = repo.findById(id).orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND) }
    @Transactional
    fun save(book: Book) {
        val id = repo.save(book).id

        for (authorRef in book.authors) {
            repo2.save(BookAuthor(null, book = id, author = authorRef.authorId))
        }
    }

    fun deleteById(id: Long) = repo.deleteById(id)
}