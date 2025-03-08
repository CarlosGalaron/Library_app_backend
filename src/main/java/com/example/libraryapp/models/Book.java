package com.example.libraryapp.models;

import jakarta.persistence.*;
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String state;
    private boolean isFavourite;

    @ManyToOne  // Muchos libros pueden pertenecer a un usuario
    @JoinColumn(name = "user_id", nullable = false)  // Columna de la FK en la tabla Book
    private User user;

    // Constructor vacío (necesario para JPA)
    public Book() {}

    // Constructor con parámetros
    public Book(String title, String author, String state, boolean isFavourite, User user) {
        this.title = title;
        this.author = author;
        this.state = state;
        this.isFavourite = isFavourite;
        this.user = user;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}