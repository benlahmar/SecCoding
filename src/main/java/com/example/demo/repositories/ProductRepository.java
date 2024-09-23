package com.example.demo.repositories;

import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository pour l'entité Product, permettant de gérer les opérations CRUD.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);
}
