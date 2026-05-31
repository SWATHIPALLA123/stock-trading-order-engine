package com.example.stocktrading.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TradeResponseDto {

    private Long id;
    private Double price;
    private Integer quantity;
    private LocalDateTime executedAt;
}