package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO #1: `OrderRepository` 생성
public interface OrderRepository extends JpaRepository<Order, Long> {
}
