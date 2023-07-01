package com.electronicsshop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "es_order")
public class Order extends BaseEntity {

    @Column(name = "user_id")
    protected UUID userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    protected User user;

    protected double total;

    @OneToMany(mappedBy = "order")
    protected List<OrderItem> items;
}
