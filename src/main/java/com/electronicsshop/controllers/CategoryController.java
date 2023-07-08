package com.electronicsshop.controllers;

import com.electronicsshop.dto.CategoryRequest;
import com.electronicsshop.dto.CategoryResponse;
import com.electronicsshop.services.ICategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    protected final ICategoryService categoryService;

    @GetMapping("/all")
    public List<CategoryResponse> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/category-by-id/{id}")
    public CategoryResponse getCategoryById(@PathVariable("id") String id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @RequestBody CategoryRequest dto) {
        return categoryService.save(dto);
    }
}
