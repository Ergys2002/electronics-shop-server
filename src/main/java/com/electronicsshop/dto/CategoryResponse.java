package com.electronicsshop.dto;

import com.electronicsshop.entities.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.PrePersist;
import org.springframework.beans.factory.annotation.Value;

import java.util.Set;

public interface CategoryResponse {
    String getId();

    String getTitle();

    default int getNumOfProductsInCategory(){
        return getProducts().size();
    }

    @JsonIgnore
    Set<Product> getProducts();

}
