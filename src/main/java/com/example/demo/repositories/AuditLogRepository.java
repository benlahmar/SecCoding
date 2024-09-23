package com.example.demo.repositories;

import com.example.demo.entities.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository pour l'entité AuditLog, permettant de gérer les opérations CRUD.
 */
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findByUserId(Long userId);
}
