package com.electronicsshop.entities;

import com.electronicsshop.dto.ProductRequest;
import com.electronicsshop.dto.ProductResponse;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "es_category")
public class Category extends BaseEntity {
    protected String title;
    @JsonManagedReference
    @OneToMany(mappedBy = "category")
    protected Set<Product> products;
}
