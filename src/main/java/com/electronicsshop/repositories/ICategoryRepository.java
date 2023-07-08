package com.electronicsshop.repositories;

import com.electronicsshop.dto.CategoryResponse;
import com.electronicsshop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, UUID> {
    Optional<Category> findByTitleEqualsIgnoreCase(String title);

    @Query(" from Category p")
    List<CategoryResponse> getAll();

    CategoryResponse findCategoryById(UUID id);
    @Query("SELECT c.id AS id, c.title AS title, COUNT(p) AS numOfProductsInCategory " +
            "FROM Category c LEFT JOIN Product p ON c.id = p.categoryId " +
            "GROUP BY c.id, c.title")
    List<CategoryResponse> getCategoryProductsCount();

}
