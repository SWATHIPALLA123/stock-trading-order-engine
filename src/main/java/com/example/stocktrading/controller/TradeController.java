package com.example.stocktrading.controller;

import com.example.stocktrading.dto.TradeResponseDto;
import com.example.stocktrading.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trades")
@RequiredArgsConstructor
public class TradeController {

    private final TradeService tradeService;

    @GetMapping("/stock/{symbol}")
    public List<TradeResponseDto> getTradesByStock(
            @PathVariable String symbol) {

        return tradeService.getTradesByStock(symbol);
    }
}