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

    Double price;

    String description;

    String brand;

    String category;

    @Enumerated(EnumType.STRING)
    Status status;

    Boolean available=true;

    Boolean active=true;

    Boolean deleted=false;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    String createdBy;

    String modifiedBy;
}
