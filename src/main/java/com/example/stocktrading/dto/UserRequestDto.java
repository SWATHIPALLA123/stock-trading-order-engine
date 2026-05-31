package com.example.stocktrading.dto;

import lombok.Data;

@Data
public class UserRequestDto {

    private String name;
    private String email;
    private Double balance;
}