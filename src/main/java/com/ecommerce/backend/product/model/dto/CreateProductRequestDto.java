package com.ecommerce.backend.product.model.dto;

import com.ecommerce.backend.product.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequestDto {
    private String productName;

    private Double productPrice;

    private String productDescription;

    private String productBrand;

    private String productCategory;

    private Status productStatus;
}
