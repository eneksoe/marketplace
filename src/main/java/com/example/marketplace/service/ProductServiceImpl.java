package com.example.marketplace.service;

import com.example.marketplace.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product(++ID, "iphone", "Simple description", 1200, "Tallinn", "Johan"));
        products.add(new Product(++ID, "samsung", "Simple description", 1000, "Tartu", "Ella"));

    }

    public List<Product> getAll() {
        return products;
    }

    public void create(Product product) {
        product.setId(++ID);
        products.add(product);
    }

    public void delete(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    @Override
    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id))
                return product;
        }
        return null;
    }
}
