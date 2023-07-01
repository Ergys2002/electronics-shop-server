package com.electronicsshop.services;

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
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ProductService implements IProductService {
    protected final IProductRepository productRepository;
    protected final ICategoryRepository categoryRepository;

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.getAll();
    }

    @Override
    public void save(ProductRequest dto) {
        UUID categoryId = UUID.fromString(dto.getCategoryId());
        Optional<Category> dbCategory = categoryRepository.findById(categoryId);
        if (dbCategory.isEmpty())
            throw new RuntimeException(String.format("Category with id %s is not found", dto.getCategoryId()));

        Product dbItem = Product.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .banner(dto.getBanner())
                .sale(dto.isSale())
                .salePrice(dto.getSalePrice())
                .categoryId(categoryId)
                .build();
        productRepository.save(dbItem);
    }
}
