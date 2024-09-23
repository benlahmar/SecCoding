package com.example.demo.repositories;

import com.example.demo.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository pour l'entité Invoice, permettant de gérer les opérations CRUD.
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
