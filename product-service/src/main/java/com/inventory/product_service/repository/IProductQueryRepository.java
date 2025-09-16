package com.inventory.product_service.repository;


import com.inventory.product_service.model.Product;

import java.util.List;

public interface IProductQueryRepository {
    List<Product> findProductsByMinStock(int stockThreshold);
    List<Product> searchByName(String keyword);
    Product saveProduct(Product product);
}

