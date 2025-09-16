package com.inventory.product_service.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inventory.product_service.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;


public class IProductQueryRepositoryImpl implements IProductQueryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findProductsByMinStock(int stockThreshold) {
        String jpql = "SELECT p FROM Product p WHERE p.stock < :stock";
        TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
        query.setParameter("stock", stockThreshold);
        return query.getResultList();
    }

    @Override
    public List<Product> searchByName(String keyword) {
        String jpql = "SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))";
        TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
        query.setParameter("keyword", keyword);
        return query.getResultList();
    }

    @Override
    public Product saveProduct(Product product) {
        entityManager.persist(product);
        return product;
    }
}

