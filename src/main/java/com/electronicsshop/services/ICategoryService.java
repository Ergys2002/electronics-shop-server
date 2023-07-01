package com.electronicsshop.services;

import com.electronicsshop.dto.CategoryRequest;
import com.electronicsshop.dto.ProductRequest;
import com.electronicsshop.dto.ProductResponse;

import java.util.List;

public interface ICategoryService {

    String save(CategoryRequest dto);
}
