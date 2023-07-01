package com.electronicsshop.controllers;

import com.electronicsshop.dto.CategoryRequest;
import com.electronicsshop.services.ICategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    protected final ICategoryService categoryService;

    @PostMapping("/save")
    public String saveProduct(@Valid @RequestBody CategoryRequest dto) {
        return categoryService.save(dto);
    }
}
