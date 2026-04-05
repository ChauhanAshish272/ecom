package com.ecommerce.backend.product.util;

import com.ecommerce.backend.product.model.dto.ProductDto;
import com.ecommerce.backend.product.model.entity.Product;

public class ProductUtil {
    public static ProductDto mapToProductDto(Product product) {
        return ProductDto.builder()
                .productId(product.getId())
                .productName(product.getName())
                .productPrice(product.getPrice())
                .productCategory(product.getCategory())
                .productBrand(product.getBrand())
                .productDescription(product.getDescription())
                .productStatus(product.getProductStatus().toString())
                .productAvailable(product.getAvailable())
                .createdAt(product.getCreatedAt().toString())
                .updatedAt(product.getUpdatedAt().toString())
                .createdBy(product.getCreatedBy())
                .modifiedBy(product.getModifiedBy())
                .build();
    }
}
