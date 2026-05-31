package com.example.stocktrading.controller;

import com.example.stocktrading.dto.OrderRequestDto;
import com.example.stocktrading.dto.OrderResponseDto;
import com.example.stocktrading.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/buy")
    public OrderResponseDto placeBuyOrder(
            @RequestBody OrderRequestDto dto) {
        return orderService.placeBuyOrder(dto);
    }

    @PostMapping("/sell")
    public OrderResponseDto placeSellOrder(
            @RequestBody OrderRequestDto dto) {
        return orderService.placeSellOrder(dto);
    }

    @DeleteMapping("/{id}")
    public String cancelOrder(@PathVariable Long id) {
        orderService.cancelOrder(id);
        return "Order Cancelled Successfully";
    }

    @GetMapping("/user/{userId}")
    public List<OrderResponseDto> getUserOrders(
            @PathVariable Long userId) {
        return orderService.getUserOrders(userId);
    }
}