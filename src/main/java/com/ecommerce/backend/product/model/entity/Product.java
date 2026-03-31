package com.ecommerce.backend.product.model.entity;

import com.ecommerce.backend.product.model.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String description;

    String brand;

    String category;

    @Enumerated(EnumType.STRING)
    Status status;

    Boolean available;

    Boolean active;

    Boolean deleted;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}
