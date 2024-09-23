package com.example.demo.repositories;

import com.example.demo.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository pour l'entité Cart, permettant de gérer les opérations CRUD.
 */
public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUserId(Long userId);
}
