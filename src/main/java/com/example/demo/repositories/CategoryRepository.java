package com.example.demo.repositories;

import com.example.demo.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository pour l'entité Category, permettant de gérer les opérations CRUD.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
