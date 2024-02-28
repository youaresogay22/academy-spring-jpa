package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetails.PrimaryKey> {
}
