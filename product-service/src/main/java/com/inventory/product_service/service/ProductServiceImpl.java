package com.inventory.product_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inventory.product_service.model.Product;
import com.inventory.product_service.repository.IProductQueryRepository;
import com.inventory.product_service.repository.IProductQueryRepositoryImpl;
import com.inventory.product_service.repository.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService{

@Autowired
@Qualifier("productRepository")
private ProductRepository repo;

    @Override
public List<Product> findProductsByMinStock(int stock) {
    return repo.findProductsByMinStock(stock);
}

@Override
public List<Product> searchByName(String name) {
    return repo.searchByName(name);
       }

@Override
public Product saveProduct(Product product) {
    return repo.save(product);
    }
}