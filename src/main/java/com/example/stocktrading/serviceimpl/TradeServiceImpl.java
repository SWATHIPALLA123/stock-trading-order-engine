package com.example.stocktrading.serviceimpl;

import com.example.stocktrading.dto.TradeResponseDto;
import com.example.stocktrading.entity.Trade;
import com.example.stocktrading.repository.TradeRepository;
import com.example.stocktrading.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TradeServiceImpl implements TradeService {

    private final TradeRepository tradeRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TradeResponseDto> getTradesByStock(String symbol) {

        List<Trade> trades = tradeRepository.findAll();

        return trades.stream()
                .map(trade -> modelMapper.map(trade, TradeResponseDto.class))
                .collect(Collectors.toList());
    }
}