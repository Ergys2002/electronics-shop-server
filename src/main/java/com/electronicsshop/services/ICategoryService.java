package com.electronicsshop.services;

import com.electronicsshop.dto.CategoryRequest;
import com.electronicsshop.dto.CategoryResponse;
import com.electronicsshop.dto.ProductRequest;
import com.electronicsshop.dto.ProductResponse;
import com.electronicsshop.entities.Category;

import java.util.List;
import java.util.UUID;

public interface ICategoryService {

    String save(CategoryRequest dto);

    List<CategoryResponse> getAllCategories();

    CategoryResponse getCategoryById(String id);

    List<CategoryResponse> getCategoryStock();
}
