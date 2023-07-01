package com.electronicsshop.services;

import com.electronicsshop.dto.CategoryRequest;
import com.electronicsshop.dto.ProductRequest;
import com.electronicsshop.dto.ProductResponse;
import com.electronicsshop.entities.Category;
import com.electronicsshop.entities.Product;
import com.electronicsshop.repositories.ICategoryRepository;
import com.electronicsshop.repositories.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService {
    protected final ICategoryRepository categoryRepository;

    /*@Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.getAll();
    }*/

    @Override
    public String save(CategoryRequest dto) {
        Category dbItem = Category.builder()
                .title(dto.getTitle())
                .build();
        dbItem = categoryRepository.save(dbItem);
        return dbItem.getId().toString();
    }
}
