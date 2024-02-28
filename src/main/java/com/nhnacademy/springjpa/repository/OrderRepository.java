package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO : #6 실습 - 기본 repository가 custom repository를 상속하도록 수정하세요.
public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryCustom {
}
