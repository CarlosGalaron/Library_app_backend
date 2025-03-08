package com.example.libraryapp.services;

import com.example.libraryapp.models.Book;
import com.example.libraryapp.models.User;
import com.example.libraryapp.repositories.BookRepository;
import com.example.libraryapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    // Obtener todos los libros de un usuario
    public List<Book> getBooksByUser(String firebaseUid) {
        User user = userRepository.findByFirebaseUid(firebaseUid);
        return bookRepository.findByUser(user);
    }

    // Crear un libro para un usuario
    public Book addBook(Book book, String firebaseUid) {
        User user = userRepository.findByFirebaseUid(firebaseUid);
        if (user == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        book.setUser(user);
        return bookRepository.save(book);
    }

    // Eliminar un libro por ID (solo si pertenece al usuario)
    public void deleteBook(Long id, String firebaseUid) {
        User user = userRepository.findByFirebaseUid(firebaseUid);
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent() && optionalBook.get().getUser().equals(user)) {
            bookRepository.deleteById(id);
        } else {
            throw new RuntimeException("Libro no encontrado o no pertenece al usuario");
        }
    }

    // Actualizar un libro (solo si pertenece al usuario)
    public Book updateBook(Long id, Book bookDetails, String firebaseUid) {
        User user = userRepository.findByFirebaseUid(firebaseUid);
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent() && optionalBook.get().getUser().equals(user)) {
            Book book = optionalBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setState(bookDetails.getState());
            book.setFavourite(bookDetails.isFavourite());
            return bookRepository.save(book);
        } else {
            throw new RuntimeException("Libro no encontrado o no pertenece al usuario");
        }
    }
}