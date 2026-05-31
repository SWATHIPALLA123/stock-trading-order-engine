package com.example.stocktrading.repository;

import com.example.stocktrading.entity.Order;
import com.example.stocktrading.entity.Stock;
import com.example.stocktrading.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);

    List<Order> findByStock(Stock stock);

}