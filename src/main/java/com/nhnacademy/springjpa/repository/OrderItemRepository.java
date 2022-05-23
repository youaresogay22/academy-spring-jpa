package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO #2: `OrderItemRepository` 생성
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItem.Pk> {
}
