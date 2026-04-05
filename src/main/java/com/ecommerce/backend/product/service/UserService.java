package com.ecommerce.backend.product.service;

import com.ecommerce.backend.product.model.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUerById(Long id);
}
