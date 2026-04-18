package com.ecommerce.backend.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDto {
    private String userFirstName;
    private String userLastName;
    private String userMobileNumber;
    private String userGender;
    private LocalDateTime userDateOfBirth;

    private String userAddress;
    private String userCity;
    private String userState;
    private String userCountry;
    private String userPostalCode;
}
