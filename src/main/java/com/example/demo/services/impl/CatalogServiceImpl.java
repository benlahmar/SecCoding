package com.example.demo.services.impl;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    // Gestion des catégories
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long categoryId, Category categoryDetails) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setName(categoryDetails.getName());
            return categoryRepository.save(category);
        }
        throw new RuntimeException("Catégorie non trouvée avec l'ID : " + categoryId);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public Optional<Category> findCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    // Gestion des produits
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            product.setDescription(productDetails.getDescription());
            product.setCategory(productDetails.getCategory());
            return productRepository.save(product);
        }
        throw new RuntimeException("Produit non trouvé avec l'ID : " + productId);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Optional<Product> findProductById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public List<Product> findAllProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
