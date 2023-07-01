package com.electronicsshop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "es_order_item")
public class OrderItem extends BaseEntity {

    @Column(name = "product_id")
    protected UUID productId;

    @Column(name = "product_title")
    protected String productTitle;

    @Column(name = "product_price")
    protected double productPrice;

    protected int quantity;

    @Column(name = "order_id")
    protected UUID orderId;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    protected Order order;
}
