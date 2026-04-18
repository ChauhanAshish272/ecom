package com.ecommerce.backend.product.service.impl;

import com.ecommerce.backend.product.exception.NotFoundException;
import com.ecommerce.backend.product.model.dto.CreateUserDto;
import com.ecommerce.backend.product.model.dto.UpdateUserDto;
import com.ecommerce.backend.product.model.dto.UserDto;
import com.ecommerce.backend.product.model.entity.User;
import com.ecommerce.backend.product.repository.UserRepository;
import com.ecommerce.backend.product.service.UserService;
import com.ecommerce.backend.product.util.CommonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(CommonUtil::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUerById(Long id) {
        return CommonUtil.mapToUserDto(userRepository.findById(id).orElseThrow(()->{
            log.warn("User with id= {} not found",id);
            return new NotFoundException("User with id= "+id+" not found");
        }));
    }

    // TODO: Need to set created by when implemented the identity context here, Email service call when created user for email verification
    @Override
    public UserDto create(CreateUserDto createUserDto) {
        User user = new User();
        user.setFirstName(createUserDto.getUserFirstName());
        user.setLastName(createUserDto.getUserLastName());
        user.setEmail(createUserDto.getUserEmail());
        user.setPassword(passwordEncoder.encode(createUserDto.getUserPassword()));
        user.setDateOfBirth(createUserDto.getUserDateOfBirth());
        user.setGender(createUserDto.getUserGender());
        user.setMobileNumber(createUserDto.getUserMobileNumber());
        user.setAddress(createUserDto.getUserAddress());
        user.setState(createUserDto.getUserState());
        user.setCountry(createUserDto.getUserCountry());
        user.setCity(createUserDto.getUserCity());
        user.setPostalCode(createUserDto.getUserPostalCode());
        user.setIsActive(false);
        user.setIsDeleted(false);
        user.setEmailVerified(false);
        return CommonUtil.mapToUserDto(userRepository.save(user));
    }


    @Override
    public UserDto update(Long userId,UpdateUserDto updateUserDto) {
        User newUser = userRepository.findById(userId).orElseThrow(()->{
            log.warn("User with id= {} not found",userId);
            return new NotFoundException("User with id= "+userId+" not found");
        });
        if (updateUserDto.getUserFirstName() != null && !updateUserDto.getUserFirstName().trim().isEmpty()) {
            newUser.setFirstName(updateUserDto.getUserFirstName());
        }

        if (updateUserDto.getUserLastName() != null && !updateUserDto.getUserLastName().trim().isEmpty()) {
            newUser.setLastName(updateUserDto.getUserLastName());
        }

        if (updateUserDto.getUserMobileNumber() != null && !updateUserDto.getUserMobileNumber().trim().isEmpty()) {
            newUser.setMobileNumber(updateUserDto.getUserMobileNumber());
        }

        if (updateUserDto.getUserGender() != null && !updateUserDto.getUserGender().trim().isEmpty()) {
            newUser.setGender(updateUserDto.getUserGender());
        }

        if (updateUserDto.getUserDateOfBirth() != null) {
            newUser.setDateOfBirth(updateUserDto.getUserDateOfBirth());
        }

        if (updateUserDto.getUserAddress() != null && !updateUserDto.getUserAddress().trim().isEmpty()) {
            newUser.setAddress(updateUserDto.getUserAddress());
        }

        if (updateUserDto.getUserCity() != null && !updateUserDto.getUserCity().trim().isEmpty()) {
            newUser.setCity(updateUserDto.getUserCity());
        }

        if (updateUserDto.getUserState() != null && !updateUserDto.getUserState().trim().isEmpty()) {
            newUser.setState(updateUserDto.getUserState());
        }

        if (updateUserDto.getUserCountry() != null && !updateUserDto.getUserCountry().trim().isEmpty()) {
            newUser.setCountry(updateUserDto.getUserCountry());
        }

        if (updateUserDto.getUserPostalCode() != null && !updateUserDto.getUserPostalCode().trim().isEmpty()) {
            newUser.setPostalCode(updateUserDto.getUserPostalCode());
        }
        return CommonUtil.mapToUserDto(userRepository.save(newUser));
    }

    @Override
    public boolean delete(Long id) {
        User user=userRepository.findById(id).orElseThrow(()->{
            log.warn("User with id= {} not found",id);
            return new NotFoundException("User with id= "+id+" not found");
        });
        user.setIsDeleted(true);
        user.setIsActive(false);
        user.setEmailVerified(false);
        user.setPassword(null);
        userRepository.save(user);
        return true;
    }

    @Override
    public UserDto activate(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> {
            log.warn("User with id= {} not found",id);
            return new NotFoundException("User with id= "+id+" not found");
        });
        user.setIsActive(true);
        user.setIsDeleted(false);
        user.setEmailVerified(false);
        return CommonUtil.mapToUserDto(userRepository.save(user));
    }


}
