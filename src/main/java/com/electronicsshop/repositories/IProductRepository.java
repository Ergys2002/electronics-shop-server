package com.electronicsshop.repositories;

import com.electronicsshop.dto.ProductResponse;
import com.electronicsshop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IProductRepository extends JpaRepository<Product, UUID> {

    @Query(" from Product p")
    List<ProductResponse> getAll();
}
