package com.example.demo.repositories;


import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repository pour l'entité User, permettant de gérer les opérations CRUD.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

