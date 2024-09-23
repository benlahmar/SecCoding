package com.example.demo.repositories;

import com.example.demo.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository pour l'entité Review, permettant de gérer les opérations CRUD.
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProductId(Long productId);
}
