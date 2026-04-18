package com.ecommerce.backend.product.model.dto;

import com.ecommerce.backend.product.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String gender;
    private LocalDateTime dateOfBirth;

    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;

    private Boolean isActive;
    private Boolean emailVerified;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
