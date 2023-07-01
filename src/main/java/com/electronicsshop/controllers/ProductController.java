package com.electronicsshop.controllers;

import com.electronicsshop.dto.ProductRequest;
import com.electronicsshop.dto.ProductResponse;
import com.electronicsshop.services.IProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    protected final IProductService productService;

    @GetMapping
    public List<ProductResponse> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/save")
    public void saveProduct(@Valid @RequestBody ProductRequest dto) {
        productService.save(dto);
    }
}
