package com.ecommerce.backend.product.model.dto;

import com.ecommerce.backend.product.model.enums.UserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {

    @NotBlank(message = "User first name is required")
    private String userFirstName;
    private String userLastName;
    @Email
    @NotBlank(message = "User Email is required")
    private String userEmail;
    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Mobile number must be 10 digits and start with 6, 7, 8, or 9"
    )
    private String userMobileNumber;
    @NotBlank(message = "User Password is required")
    private String userPassword;
    private String userGender;
    @NotBlank(message = "User date of birth is required")
    private LocalDateTime userDateOfBirth;

    @NotBlank(message = "User address is required")
    private String userAddress;
    @NotBlank(message = "User city is required")
    private String userCity;
    @NotBlank(message = "User State is required")
    private String userState;
    @NotBlank(message = "User Country is required")
    private String userCountry;
    @NotBlank(message = "User Postal Code is required")
    private String userPostalCode;
}
