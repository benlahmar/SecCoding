package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;

import java.util.List;
import java.util.Optional;

/**
 * Interface du service pour la gestion des catégories et des produits.
 * Contient les méthodes CRUD pour les entités Category et Product.
 */
public interface CatalogService {

    // Gestion des catégories
    Category createCategory(Category category);

    Category updateCategory(Long categoryId, Category categoryDetails);

    void deleteCategory(Long categoryId);

    Optional<Category> findCategoryById(Long categoryId);

    List<Category> findAllCategories();

    // Gestion des produits
    Product createProduct(Product product);

    Product updateProduct(Long productId, Product productDetails);

    void deleteProduct(Long productId);

    Optional<Product> findProductById(Long productId);

    List<Product> findAllProductsByCategory(Long categoryId);
    
    List<Product> findAllProducts();
    

   }
