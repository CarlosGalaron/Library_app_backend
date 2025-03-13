package com.example.libraryapp.controllers;

import com.example.libraryapp.models.Book;
import com.example.libraryapp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookService bookService;

    // Obtener todos los libros de un usuario
    @GetMapping
    public List<Book> getBooks(@RequestHeader("Firebase-Uid") String firebaseUid) {
        return bookService.getBooksByUser(firebaseUid);
    }

    // Crear un libro para un usuario
    @PostMapping
    public Book addBook(@RequestBody Book book, @RequestHeader("Firebase-Uid") String firebaseUid) {
        return bookService.addBook(book, firebaseUid);
    }

    // Eliminar un libro por ID (solo si pertenece al usuario)
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id, @RequestHeader("Firebase-Uid") String firebaseUid) {
        bookService.deleteBook(id, firebaseUid);
    }

    // Actualizar un libro (solo si pertenece al usuario)
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book,
            @RequestHeader("Firebase-Uid") String firebaseUid) {
        return bookService.updateBook(id, book, firebaseUid);
    }

    // Cambiar el estado de un libro
    @PutMapping("/{id}/toggle-state")
    public Book toggleBookState(@PathVariable Long id, @RequestHeader("Firebase-Uid") String firebaseUid) {
        return bookService.toggleBookState(id, firebaseUid);
    }

    // Marcar/desmarcar como favorito
    @PutMapping("/{id}/toggle-favorite")
    public Book toggleFavorite(@PathVariable Long id, @RequestHeader("Firebase-Uid") String firebaseUid) {
        return bookService.toggleFavorite(id, firebaseUid);
    }
}