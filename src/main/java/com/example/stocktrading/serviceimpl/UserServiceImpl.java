package com.example.stocktrading.serviceimpl;

import com.example.stocktrading.dto.UserRequestDto;
import com.example.stocktrading.dto.UserResponseDto;
import com.example.stocktrading.entity.User;
import com.example.stocktrading.repository.UserRepository;
import com.example.stocktrading.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto dto) {

        User user = modelMapper.map(dto, User.class);

        User savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserResponseDto.class);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserResponseDto.class))
                .collect(Collectors.toList());
    }
}