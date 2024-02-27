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
import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class OrdersTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testOrdersEntity() {
        users user = entityManager.find(users.class, "admin");

        Orders orders1 = new Orders();

        orders1.setOrderID(107);
        orders1.setUsers(user);
        orders1.setOrderDate(LocalDateTime.now());
        orders1.setShipDate(LocalDateTime.now());

        entityManager.persist(orders1);
        entityManager.flush();

        Orders orders2 = entityManager.find(Orders.class, 107);

        Assertions.assertEquals(107, orders2.getOrderID());
        Assertions.assertEquals("admin", orders2.getUsers().getUserId());
        Assertions.assertInstanceOf(LocalDateTime.class, orders2.getOrderDate());
        Assertions.assertInstanceOf(LocalDateTime.class, orders2.getShipDate());
    }
}