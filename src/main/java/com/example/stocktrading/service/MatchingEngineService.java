package com.example.stocktrading.service;

import com.example.stocktrading.entity.Order;

public interface MatchingEngineService {

    void matchOrder(Order order);
}