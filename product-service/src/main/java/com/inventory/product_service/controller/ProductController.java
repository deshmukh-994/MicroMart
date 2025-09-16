package com.inventory.product_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inventory.product_service.model.Product;
import com.inventory.product_service.service.IProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired IProductService service;

    @GetMapping("/low-stock")
public List<Product> getLowStockProducts(@RequestParam int threshold) {
    return service.findProductsByMinStock(threshold);
}

@GetMapping("/search")
public List<Product> searchProductsByName(@RequestParam String keyword) {
    return service.searchByName(keyword);
}

@PostMapping
public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    Product saved = service.saveProduct(product);
    return new ResponseEntity<>(saved, HttpStatus.CREATED);
}

}
