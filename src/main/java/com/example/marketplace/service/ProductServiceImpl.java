package com.example.marketplace.service;

import com.example.marketplace.model.Product;
import com.example.marketplace.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAll(String name) {
        if (name != null) return productRepository.findByName(name);
        return productRepository.findAll();
    }

    public void create(Product product) {
        log.info("Saving new {}", product);
        productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProductById(Long id) {
        var product = productRepository.findById(id).orElse(null);
        return product;
    }
}
