package com.electronicsshop.repositories;

import com.electronicsshop.dto.ProductResponse;
import com.electronicsshop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IProductRepository extends JpaRepository<Product, UUID> {

    @Query(" from Product p")
    List<ProductResponse> getAll();

//    List<ProductResponse> findTop5NewestProducts();

    Optional<Product> findByTitleEqualsIgnoreCase(String title);

    List<ProductResponse> findTop5BySaleIsTrue();
    @Query("SELECT p FROM Product p ORDER BY p.createdAt DESC limit 3")
    List<ProductResponse> findTop3ByCreatedAtOrderByCreatedAtDesc();
}
