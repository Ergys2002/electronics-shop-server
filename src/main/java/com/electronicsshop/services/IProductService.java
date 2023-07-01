package com.electronicsshop.services;

import com.electronicsshop.dto.ProductRequest;
import com.electronicsshop.dto.ProductResponse;

import java.util.List;

public interface IProductService {
    List<ProductResponse> getAllProducts();

    void save(ProductRequest dto);
}
