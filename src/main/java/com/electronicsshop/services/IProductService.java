package com.electronicsshop.services;

import com.electronicsshop.dto.ProductRequest;
import com.electronicsshop.dto.ProductResponse;

import java.awt.print.Pageable;
import java.util.List;

public interface IProductService {
    List<ProductResponse> getAll();

    void save(ProductRequest dto);

    public List<ProductResponse> getTopFiveProductsInSale();

    List<ProductResponse> getTopThreeNewestProducts();
}
