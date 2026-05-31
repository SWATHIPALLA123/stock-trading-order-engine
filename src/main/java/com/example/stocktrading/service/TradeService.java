package com.example.stocktrading.service;

import com.example.stocktrading.dto.TradeResponseDto;

import java.util.List;

public interface TradeService {

    List<TradeResponseDto> getTradesByStock(String symbol);
}