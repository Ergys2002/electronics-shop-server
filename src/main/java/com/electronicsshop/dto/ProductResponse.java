package com.electronicsshop.dto;

import lombok.*;


public interface ProductResponse {
    String getId();

    String getTitle();

    double getPrice();

    boolean isSale();

    double getSalePrice();

    String getBanner();
}
