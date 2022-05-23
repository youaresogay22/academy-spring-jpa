package com.nhnacademy.springjpa.entity;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

// TODO #2: test case
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
    @ContextConfiguration(classes = RootConfig.class),
    @ContextConfiguration(classes = WebConfig.class)
})
public class OrderItemTest {
    @PersistenceContext
    EntityManager entityManager;

    @Test
    void test() {
        Item item1 = new Item();
        item1.setItemId(101L);
        item1.setItemName("egg");
        item1.setPrice(1000L);

        entityManager.persist(item1);

        Item item2 = new Item();
        item2.setItemId(102L);
        item2.setItemName("milk");
        item2.setPrice(2500L);

        entityManager.persist(item2);

        Order order1 = new Order();
        order1.setOrderId(3001L);
        order1.setOrderDate(new Date());

        entityManager.persist(order1);

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setPk(new OrderItem.Pk(order1.getOrderId(), 1));
        orderItem1.setItem(item1);
        orderItem1.setQuantity(10);
        orderItem1.setOrder(order1);

        entityManager.persist(orderItem1);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setPk(new OrderItem.Pk(order1.getOrderId(), 2));
        orderItem2.setItem(item2);
        orderItem2.setQuantity(3);
        orderItem2.setOrder(order1);

        entityManager.persist(orderItem2);

        assertThat(orderItem2.getOrder().getOrderId()).isEqualTo(order1.getOrderId());

        entityManager.flush();
    }

}
