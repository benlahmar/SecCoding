package com.example.demo.entities;

import jakarta.persistence.*;

/**
 * Représente un produit disponible à la vente sur la plateforme e-commerce.
 * Cette entité contient les informations essentielles du produit comme le nom, 
 * le prix et la catégorie.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;
    
    private String image;
    
    private int qte;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Ajout de la relation ManyToOne avec Supplier
    @ManyToOne
    @JoinColumn(name = "supplier_id") // La clé étrangère pour Supplier dans Product
    private Supplier supplier;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Inventory inventory; // Associer le produit à un inventaire
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}
	
	 public boolean isAvailability() {
	        return qte>0;
	    }
}
