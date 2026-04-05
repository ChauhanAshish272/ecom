package com.ecommerce.backend.product.controller;

import com.ecommerce.backend.product.model.dto.ResponseDto;
import com.ecommerce.backend.product.model.dto.UserDto;
import com.ecommerce.backend.product.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get/all")
    public ResponseDto<?> getAllUsers() {
        List<UserDto> userDtos=userService.getAllUsers();
        return new ResponseDto<>(
                true,
                "Users Fetched Successfully",
                userDtos
        );
    }

    @GetMapping("/get/{id}")
    public ResponseDto<?> getUserBYId(@PathVariable Long id) {
        UserDto userDto=userService.getUerById(id);
        return new ResponseDto<>(
                true,
                "User Fetched Successfully",
                userDto
        );
    }
}
