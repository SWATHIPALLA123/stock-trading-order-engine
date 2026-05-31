package com.example.stocktrading.service;

import com.example.stocktrading.dto.StockResponseDto;

import java.util.List;

public interface StockService {

    List<StockResponseDto> getAllStocks();
}