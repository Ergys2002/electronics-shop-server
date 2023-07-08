package com.electronicsshop.services;

import com.electronicsshop.dto.*;
import com.electronicsshop.entities.Category;
import com.electronicsshop.entities.Product;
import com.electronicsshop.repositories.ICategoryRepository;
import com.electronicsshop.repositories.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService {
    protected final ICategoryRepository categoryRepository;

    @Override
    public String save(CategoryRequest dto) {
        Category dbItem = Category.builder()
                .title(dto.getTitle())
                .build();
        dbItem = categoryRepository.save(dbItem);
        return dbItem.getId().toString();
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.getAll();
    }

    @Override
    public CategoryResponse getCategoryById(String id) {
        UUID categoryId = UUID.fromString(id);
        return categoryRepository.findCategoryById(categoryId);
    }

    @Override
    public List<CategoryResponse> getCategoryStock() {
        return categoryRepository.getCategoryProductsCount();
    }


}
