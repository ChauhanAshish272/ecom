package com.ecommerce.backend.product.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long productId;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private String productCategory;
    private String productBrand;
    private String productStatus;
    private Boolean productAvailable;
    private String createdAt;
    private String updatedAt;
    private String modifiedBy;
    private String createdBy;
}
