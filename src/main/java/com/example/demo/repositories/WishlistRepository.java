package com.example.demo.repositories;

import com.example.demo.entities.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository pour l'entité Wishlist, permettant de gérer les opérations CRUD.
 */
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    Optional<Wishlist> findByUserId(Long userId);
}
