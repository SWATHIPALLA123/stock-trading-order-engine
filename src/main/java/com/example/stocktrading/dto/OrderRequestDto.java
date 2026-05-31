package com.example.stocktrading.dto;

import lombok.Data;

@Data
public class OrderRequestDto {

    private Long userId;
    private Long stockId;
    private Double price;
    private Integer quantity;
}