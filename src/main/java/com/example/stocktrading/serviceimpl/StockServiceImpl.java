package com.example.stocktrading.serviceimpl;

import com.example.stocktrading.dto.StockResponseDto;
import com.example.stocktrading.repository.StockRepository;
import com.example.stocktrading.service.StockService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StockResponseDto> getAllStocks() {

        return stockRepository.findAll()
                .stream()
                .map(stock -> modelMapper.map(stock, StockResponseDto.class))
                .collect(Collectors.toList());
    }
}