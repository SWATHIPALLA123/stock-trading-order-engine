package com.example.stocktrading.dto;

import lombok.Data;

@Data
public class StockResponseDto {

    private Long id;
    private String symbol;
    private String companyName;
}