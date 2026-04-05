package com.ecommerce.backend.product.service.impl;

import com.ecommerce.backend.product.exception.NotFoundException;
import com.ecommerce.backend.product.model.dto.UserDto;
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
}
