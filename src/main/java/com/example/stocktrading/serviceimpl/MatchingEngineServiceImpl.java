package com.example.stocktrading.serviceimpl;

import com.example.stocktrading.entity.Order;
import com.example.stocktrading.service.MatchingEngineService;
import org.springframework.stereotype.Service;

@Service
public class MatchingEngineServiceImpl implements MatchingEngineService {

    @Override
    public void matchOrder(Order order) {

        // FIFO + Price Priority Matching Logic
    }
}