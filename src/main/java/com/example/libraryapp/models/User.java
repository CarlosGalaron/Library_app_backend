package com.example.libraryapp.models;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    private String firebaseUid;  // ID único de Firebase (clave primaria)

    private String email;

    // Constructor vacío (necesario para JPA)
    public User() {}

    // Constructor con parámetros
    public User(String firebaseUid, String email) {
        this.firebaseUid = firebaseUid;
        this.email = email;
    }

    // Getters y setters
    public String getFirebaseUid() {
        return firebaseUid;
    }

    public void setFirebaseUid(String firebaseUid) {
        this.firebaseUid = firebaseUid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}