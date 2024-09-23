package com.example.demo.entities;

import jakarta.persistence.*;

/**
 * Représente un coupon ou une remise que l'utilisateur peut appliquer à une commande.
 * Cette entité contient un code coupon et le pourcentage de réduction applicable.
 */
@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private Double discountPercentage;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
