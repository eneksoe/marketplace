package com.example.marketplace.service;

import com.example.marketplace.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    void create(Product product);

    void delete(Long id);

    Product getProductById(Long id);
}
