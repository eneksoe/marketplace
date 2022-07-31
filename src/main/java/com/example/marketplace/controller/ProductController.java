package com.example.marketplace.controller;


import com.example.marketplace.model.Product;
import com.example.marketplace.model.User;
import com.example.marketplace.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String products(@RequestParam(name = "searchWord", required = false) String name, Principal principal, Model model) {
        model.addAttribute("products", productService.getAll(name));
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", name);
        return "products";
    }

    @PostMapping("/product/create")
    public String create(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                         @RequestParam("file3") MultipartFile file3, Product product,
                         Principal principal) throws IOException {
        productService.create(principal, product, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model, Principal principal) {
        Product product = productService.getProductById(id);
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
        model.addAttribute("productSeller", product.getUser());
        return "product-info";
    }

    @GetMapping("/my/products")
    public String userProducts(Principal principal, Model model) {
        User user = productService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        model.addAttribute("products", user.getProducts());
        return "my-products";
    }
}
