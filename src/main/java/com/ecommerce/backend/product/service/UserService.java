package com.ecommerce.backend.product.service;

import com.ecommerce.backend.product.model.dto.CreateUserDto;
import com.ecommerce.backend.product.model.dto.UpdateUserDto;
import com.ecommerce.backend.product.model.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUerById(Long id);

    UserDto create(CreateUserDto createUserDto);

    UserDto update(Long userId,UpdateUserDto updateUserDto);

    boolean delete(Long id);

    UserDto activate(Long id);
}
