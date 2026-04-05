package com.ecommerce.backend.product.model.dto;

import com.ecommerce.backend.product.model.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProductRequestDto {

    private String productName;

    private Double productPrice;

    private String productDescription;

    private String productBrand;

    private String productCategory;

    private ProductStatus productStatus;
}
