package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class OrderDetailsRepositoryTest {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        Products product = entityManager.find(Products.class, "1");
        users user = entityManager.find(users.class, "admin");
        Orders orders = new Orders();

        orders.setOrderID(111);
        orders.setUsers(user);
        orders.setOrderDate(LocalDateTime.now());
        orders.setShipDate(LocalDateTime.now().plusHours(1));

        OrderDetails orderDetail = new OrderDetails();

        orderDetail.setPrimaryKey(new OrderDetails.PrimaryKey(orders, product));
        orderDetail.setQuantity(10);
        orderDetail.setUnitCost(BigDecimal.valueOf(100));

        orderDetailsRepository.saveAndFlush(orderDetail);
    }

    @Test
    void test_Create() {
    }

    @Test
    void test_Read() {

    }

    @Test
    void test_Update() {

    }

    @Test
    void test_Delete() {

    }

}