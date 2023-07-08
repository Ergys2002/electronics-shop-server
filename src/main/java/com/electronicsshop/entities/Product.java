package com.electronicsshop.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "es_product")
public class Product extends BaseEntity {

    private String title;

    private double price;

    protected boolean sale;

    @Column(name = "sale_price")
    private double salePrice;

    @Column(length = 1000)
    protected String description;

    protected String banner;

    protected String photo;
    @Column(name = "total_sales")
    protected int totalSales;
    protected int stock;
    protected int rating;

    @Column(name = "category_id")
    protected UUID categoryId;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "category_id", updatable = false,insertable = false)
    protected Category category;

}
