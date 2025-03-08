package com.example.libraryapp.repositories;

import com.example.libraryapp.models.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByFirebaseUid(String firebaseUid);  // Buscar usuario por Firebase UID

    Optional<User> findByEmail(String email);  // Método para buscar un usuario por email
}

