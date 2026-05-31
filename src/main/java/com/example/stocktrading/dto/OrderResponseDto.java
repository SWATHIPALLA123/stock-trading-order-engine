package com.example.stocktrading.dto;

import com.example.stocktrading.entity.OrderStatus;
import com.example.stocktrading.entity.OrderType;
import lombok.Data;

@Data
public class OrderResponseDto {

    private Long id;
    private Long userId;
    private Long stockId;
    private OrderType orderType;
    private Double price;
    private Integer quantity;
    private Integer remainingQuantity;
    private OrderStatus status;
}