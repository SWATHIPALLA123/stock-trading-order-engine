package com.example.stocktrading.service;

import com.example.stocktrading.dto.OrderRequestDto;
import com.example.stocktrading.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {

    OrderResponseDto placeBuyOrder(OrderRequestDto dto);

    OrderResponseDto placeSellOrder(OrderRequestDto dto);

    void cancelOrder(Long orderId);

    List<OrderResponseDto> getUserOrders(Long userId);
}