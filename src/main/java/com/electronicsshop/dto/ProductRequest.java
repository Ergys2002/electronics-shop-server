package com.electronicsshop.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    @NotEmpty
    private String title;

    @Min(0)
    private double price;

    protected boolean sale;

    @Min(0)
    private double salePrice;

    @NotEmpty
    protected String description;

    @NotEmpty
    protected String banner;

    @NotEmpty
    protected String categoryId;
}
