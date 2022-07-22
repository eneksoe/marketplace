package com.example.marketplace.controller;


import com.example.marketplace.model.Product;
import com.example.marketplace.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String products(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("products", productService.getAll(name));
        return "products";
    }

    @PostMapping("/product/create")
    public String create(Product product) {
        productService.create(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
return "product-info";
    }
}
