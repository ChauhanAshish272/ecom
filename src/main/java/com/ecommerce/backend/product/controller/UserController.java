package com.ecommerce.backend.product.controller;

import com.ecommerce.backend.product.model.dto.CreateUserDto;
import com.ecommerce.backend.product.model.dto.ResponseDto;
import com.ecommerce.backend.product.model.dto.UpdateUserDto;
import com.ecommerce.backend.product.model.dto.UserDto;
import com.ecommerce.backend.product.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get/all")
    public ResponseDto<?> getAllUsers() {
        List<UserDto> userDtos = userService.getAllUsers();
        return new ResponseDto<>(
                true,
                "Users Fetched Successfully",
                userDtos
        );
    }

    @GetMapping("/get/{id}")
    public ResponseDto<?> getUserBYId(@PathVariable Long id) {
        UserDto userDto = userService.getUerById(id);
        return new ResponseDto<>(
                true,
                "User Fetched Successfully",
                userDto
        );
    }

    @PostMapping("/create")
    public ResponseDto<?> createUser(@RequestBody CreateUserDto createUserDto) {
        UserDto userDto = userService.create(createUserDto);
        return new ResponseDto<>(
                true,
                "User Created Successfully",
                userDto
        );
    }

    @PatchMapping("/update/{id}")
    public ResponseDto<?> updateUser(@PathVariable Long id, @RequestBody UpdateUserDto updateUserDto) {
        UserDto userDto = userService.update(id, updateUserDto);
        return new ResponseDto<>(
                true,
                "User Updated Successfully",
                userDto
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto<?> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseDto<>(
                true,
                "User deleted successfully"
        );
    }

    @PatchMapping("/activate/{id}")
    public ResponseDto<?> activateUser(@PathVariable Long id) {
        UserDto userDto= userService.activate(id);
        return new ResponseDto<>(
                true,
                "User Activated Successfully",
                userDto
        );
    }

}
