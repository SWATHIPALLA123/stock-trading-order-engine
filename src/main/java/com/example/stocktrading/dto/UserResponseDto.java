package com.example.stocktrading.dto;

import lombok.Data;

@Data
public class UserResponseDto {

    private Long id;
    private String name;
    private String email;
    private Double balance;
}