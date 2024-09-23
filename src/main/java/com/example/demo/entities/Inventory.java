package com.example.demo.entities;

import jakarta.persistence.*;

/**
 * Représente la gestion des stocks des produits.
 * Cette entité contient des informations sur la quantité disponible pour chaque produit.
 */
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
 // Méthode pour vérifier la disponibilité (en stock ou non)
    public boolean isAvailable() {
        return quantity > 0;
    }
}

