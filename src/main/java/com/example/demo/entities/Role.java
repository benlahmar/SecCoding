package com.example.demo.entities;

import jakarta.persistence.*;

/**
 * Représente un rôle attribué à un utilisateur (par exemple, client ou administrateur).
 * Cette entité est utilisée pour la gestion des autorisations.
 */
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    // Getters et Setters
    
    
}
