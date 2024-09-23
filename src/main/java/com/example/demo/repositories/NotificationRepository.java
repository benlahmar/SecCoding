package com.example.demo.repositories;

import com.example.demo.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository pour l'entité Notification, permettant de gérer les opérations CRUD.
 */
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserId(Long userId);
}
