package com.electronicsshop.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;


public interface ProductResponse {
    String getId();

    String getTitle();

    double getPrice();

    boolean isSale();

    double getSalePrice();

    String getBanner();

    String getPhoto();

    int getStock();

    int getTotalSales();

    int getRating();

    String getCategoryId();

    @Value("#{target.category.title}")
    String getCategoryName();
}
