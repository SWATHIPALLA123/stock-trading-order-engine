package com.example.stocktrading.serviceimpl;

import com.example.stocktrading.dto.OrderRequestDto;
import com.example.stocktrading.dto.OrderResponseDto;
import com.example.stocktrading.entity.*;
import com.example.stocktrading.exception.ResourceNotFoundException;
import com.example.stocktrading.repository.OrderRepository;
import com.example.stocktrading.repository.StockRepository;
import com.example.stocktrading.repository.UserRepository;
import com.example.stocktrading.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final StockRepository stockRepository;
    private final ModelMapper modelMapper;

    @Override
    public OrderResponseDto placeBuyOrder(OrderRequestDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found"));

        Stock stock = stockRepository.findById(dto.getStockId())
                .orElseThrow(() -> new ResourceNotFoundException("Stock Not Found"));

        Order order = new Order();
        order.setUser(user);
        order.setStock(stock);
        order.setOrderType(OrderType.BUY);
        order.setPrice(dto.getPrice());
        order.setQuantity(dto.getQuantity());
        order.setRemainingQuantity(dto.getQuantity());
        order.setStatus(OrderStatus.OPEN);
        order.setCreatedAt(LocalDateTime.now());

        Order savedOrder = orderRepository.save(order);

        return modelMapper.map(savedOrder, OrderResponseDto.class);
    }

    @Override
    public OrderResponseDto placeSellOrder(OrderRequestDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found"));

        Stock stock = stockRepository.findById(dto.getStockId())
                .orElseThrow(() -> new ResourceNotFoundException("Stock Not Found"));

        Order order = new Order();
        order.setUser(user);
        order.setStock(stock);
        order.setOrderType(OrderType.SELL);
        order.setPrice(dto.getPrice());
        order.setQuantity(dto.getQuantity());
        order.setRemainingQuantity(dto.getQuantity());
        order.setStatus(OrderStatus.OPEN);
        order.setCreatedAt(LocalDateTime.now());

        Order savedOrder = orderRepository.save(order);

        return modelMapper.map(savedOrder, OrderResponseDto.class);
    }

    @Override
    public void cancelOrder(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order Not Found"));

        order.setStatus(OrderStatus.CANCELLED);

        orderRepository.save(order);
    }

    @Override
    public List<OrderResponseDto> getUserOrders(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found"));

        return orderRepository.findByUser(user)
                .stream()
                .map(order -> modelMapper.map(order, OrderResponseDto.class))
                .collect(Collectors.toList());
    }
}