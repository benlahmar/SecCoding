package com.example.demo.repositories;

import com.example.demo.entities.Admin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@Transactional
public class AdminRepository2 {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Admin> findAdminByEmailAndPassword2(String email, String password) {
        // Requête SQL vulnérable à l'injection SQL
        String query = "SELECT * FROM admin WHERE email = '" + email + "' AND password = '" + password + "'";
        return entityManager.createNativeQuery(query, Admin.class).getResultList();
    }
}
