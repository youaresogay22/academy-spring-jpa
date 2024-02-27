package com.nhnacademy.springjpa.entity;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class OrderDetailsTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testOrderDetailsEntity() {
        Products product = entityManager.find(Products.class, "1");
        users user = entityManager.find(users.class, "admin");

        Orders orders = new Orders();

        orders.setOrderID(111);
        orders.setUsers(user);
        orders.setOrderDate(LocalDateTime.now());
        orders.setShipDate(LocalDateTime.now());
        entityManager.persist(orders);

        OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setPrimaryKey(new OrderDetails.PrimaryKey(orders, product));
        orderDetails1.setQuantity(10);
        orderDetails1.setUnitCost(BigDecimal.TEN);
        entityManager.persist(orderDetails1);

        entityManager.flush();

        OrderDetails orderDetails2 = entityManager.find(OrderDetails.class, new OrderDetails.PrimaryKey(orders, product));

        Assertions.assertEquals(111, orderDetails2.getPrimaryKey().getOrder().getOrderID());
        Assertions.assertEquals("1", orderDetails2.getPrimaryKey().getProduct().getProductID());
        Assertions.assertEquals(10, orderDetails2.getQuantity());
        Assertions.assertEquals(BigDecimal.TEN, orderDetails2.getUnitCost());
    }
}