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

    private Long userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private Boolean userActive;
    private Boolean userVerified;
    private Boolean userDeleted;
    private LocalDateTime userCreatedAt;
    private LocalDateTime userUpdatedAt;
    private String userModifiedBy;
    private String userDeletedBy;
    private UserStatus userStatus;
}
