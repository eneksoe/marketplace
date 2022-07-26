package com.example.marketplace.service;

import com.example.marketplace.model.Product;
import com.example.marketplace.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

public interface ProductService {

    List<Product> getAll(String name);

    void create(Principal principal, Product product, MultipartFile file1,
                MultipartFile file2, MultipartFile file3) throws IOException;

    void delete(Long id);

    Product getProductById(Long id);

    User getUserByPrincipal(Principal principal);
}
