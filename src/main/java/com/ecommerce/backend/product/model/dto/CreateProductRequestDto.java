package com.ecommerce.backend.product.model.dto;

import com.ecommerce.backend.product.model.enums.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequestDto {

    @NotBlank
    private String productName;

    @NotBlank
    private Double productPrice;

    @NotBlank
    private String productDescription;

    @NotBlank
    private String productBrand;

    @NotBlank
    private String productCategory;

    @NotBlank
    private Status productStatus;
}
