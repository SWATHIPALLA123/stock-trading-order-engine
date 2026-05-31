package com.example.stocktrading.service;

import com.example.stocktrading.dto.UserRequestDto;
import com.example.stocktrading.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto dto);

    List<UserResponseDto> getAllUsers();
}