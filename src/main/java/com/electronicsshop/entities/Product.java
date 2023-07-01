package com.electronicsshop.entities;


import jakarta.persistence.*;
import lombok.*;

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

    protected String description;

    protected String banner;

    @Column(name = "category_id")
    protected UUID categoryId;

    @ManyToOne
    @JoinColumn(name = "category_id", updatable = false,insertable = false)
    protected Category category;
}
