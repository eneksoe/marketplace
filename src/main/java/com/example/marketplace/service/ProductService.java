package com.example.marketplace.service;

import com.example.marketplace.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Product> getAll(String name);

    void create(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException;

    void delete(Long id);

    Product getProductById(Long id);
}
