package com.example.stocktrading.controller;

import com.example.stocktrading.dto.StockResponseDto;
import com.example.stocktrading.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping
    public List<StockResponseDto> getAllStocks() {
        return stockService.getAllStocks();
    }
}