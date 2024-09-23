package com.example.demo.repositories;

import com.example.demo.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository pour l'entité Transaction, permettant de gérer les opérations CRUD.
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
