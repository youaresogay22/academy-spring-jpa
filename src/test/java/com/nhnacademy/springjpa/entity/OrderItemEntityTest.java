package com.nhnacademy.springjpa.entity;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
public class OrderItemEntityTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testOrderItemEntity() {
        Item item1 = new Item();
        item1.setItemId(100L);
        item1.setItemName("");
        item1.setPrice(10000L);
        entityManager.persist(item1);

        Item item2 = new Item();
        item2.setItemId(200L);
        item2.setItemName("텀블러");
        item2.setPrice(20000L);
        entityManager.persist(item2);

        Order order1 = new Order();
        order1.setOrderDate(new Date());
        order1.setOrderId(1L);
        entityManager.persist(order1);

        OrderItem orderItem1 = new OrderItem();
       
        entityManager.persist(orderItem1);

        OrderItem orderItem2 = new OrderItem();

    }
}
