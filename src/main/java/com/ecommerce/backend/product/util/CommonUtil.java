package com.ecommerce.backend.product.util;

import com.ecommerce.backend.product.model.dto.ProductDto;
import com.ecommerce.backend.product.model.dto.UserDto;
import com.ecommerce.backend.product.model.entity.Product;
import com.ecommerce.backend.product.model.entity.User;

public class CommonUtil {
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

    public static UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .userId(user.getId())
                .userFirstName(user.getFirstName())
                .userLastName(user.getLastName())
                .userEmail(user.getEmail())
                .userStatus(user.getStatus())
                .userActive(user.getActive())
                .userVerified(user.getVerified())
                .userCreatedAt(user.getCreatedAt())
                .userUpdatedAt(user.getUpdatedAt())
                .userModifiedBy(user.getModifiedBy())
                .userDeletedBy(user.getDeletedBy())
                .build();
    }
}
