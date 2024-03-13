package edu.nechaev.demo.controllers

import edu.nechaev.demo.models.Book
import edu.nechaev.demo.services.BookService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/books")
class BookController(val service: BookService) {
    @GetMapping
    fun getAll(): List<Book> = service.findBooks()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Book = service.findById(id)

    @PostMapping
    fun addBook(@RequestBody book: Book) = service.save(book)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = service.deleteById(id)
}