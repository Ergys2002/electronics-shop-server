package com.electronicsshop.controllers;

import com.electronicsshop.dto.ProductRequest;
import com.electronicsshop.dto.ProductResponse;
import com.electronicsshop.services.IProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    protected final IProductService productService;

    @GetMapping("/all")
    public List<ProductResponse> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/on-sale")
    public List<ProductResponse> getOnSale(){
        return productService.getTopFiveProductsInSale();
    }

    @GetMapping("/newest")
    public List<ProductResponse> getNewest(){
        return productService.getTopThreeNewestProducts();
    }

    @PostMapping("/save")
    public void saveProduct(@Valid @RequestBody ProductRequest dto) {
        productService.save(dto);
    }
}
