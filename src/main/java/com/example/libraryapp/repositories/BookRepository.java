package com.example.libraryapp.repositories;

import com.example.libraryapp.models.Book;
import com.example.libraryapp.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByUser(User user);
}

