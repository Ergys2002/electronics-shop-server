package com.electronicsshop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Getter @Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "id", updatable = false, nullable = false)
    protected UUID id;

    @Column(name = "created_at")
    protected LocalDate createdAt;


    @PrePersist
    public void setCreatedAt() {
        createdAt = LocalDate.now();
    }
}
