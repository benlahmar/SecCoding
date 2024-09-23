package com.example.demo.entities;

import java.util.Set;

import jakarta.persistence.*;

/**
 * Représente un fournisseur qui fournit des produits à la boutique e-commerce.
 * Cette entité contient des informations sur le fournisseur, comme son nom et ses coordonnées.
 */
@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contactInfo;

    @OneToMany(mappedBy = "supplier")
    private Set<Product> products;

    // Getters et Setters

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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
