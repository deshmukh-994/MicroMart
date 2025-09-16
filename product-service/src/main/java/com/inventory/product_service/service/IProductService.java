package com.inventory.product_service.service;

import java.util.List;
import java.util.Optional;


import com.inventory.product_service.model.Product;

public interface IProductService {
    
    public List<Product> findProductsByMinStock(int stock);
    public List<Product> searchByName(String name);
    Product saveProduct(Product product);
}

