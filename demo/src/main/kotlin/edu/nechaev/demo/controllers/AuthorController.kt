package edu.nechaev.demo.controllers

import edu.nechaev.demo.models.Author
import edu.nechaev.demo.repositories.AuthorRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/authors")
class AuthorController(val repo: AuthorRepository) {
    @GetMapping
    fun getAll(): List<Author> = repo.findAll().toList();

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Author = repo.findById(id).orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND) }

    @PostMapping
    fun addBook(@RequestBody author: Author) = repo.save(author)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = repo.deleteById(id)
}