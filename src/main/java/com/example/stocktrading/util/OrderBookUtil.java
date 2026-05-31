package com.example.stocktrading.util;

import com.example.stocktrading.entity.Order;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.PriorityQueue;

@Component
public class OrderBookUtil {

    private final PriorityQueue<Order> buyOrders =
            new PriorityQueue<>(
                    Comparator.comparing(Order::getPrice)
                            .reversed()
                            .thenComparing(Order::getCreatedAt)
            );

    private final PriorityQueue<Order> sellOrders =
            new PriorityQueue<>(
                    Comparator.comparing(Order::getPrice)
                            .thenComparing(Order::getCreatedAt)
            );

    public PriorityQueue<Order> getBuyOrders() {
        return buyOrders;
    }

    public PriorityQueue<Order> getSellOrders() {
        return sellOrders;
    }

    public void addBuyOrder(Order order) {
        buyOrders.offer(order);
    }

    public void addSellOrder(Order order) {
        sellOrders.offer(order);
    }

    public Order getTopBuyOrder() {
        return buyOrders.peek();
    }

    public Order getTopSellOrder() {
        return sellOrders.peek();
    }

    public void removeBuyOrder() {
        buyOrders.poll();
    }

    public void removeSellOrder() {
        sellOrders.poll();
    }
}