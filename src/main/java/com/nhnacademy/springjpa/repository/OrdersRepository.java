package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
