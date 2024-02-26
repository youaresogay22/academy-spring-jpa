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
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class OrderItemsTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testOrderEntity() {
        OrderItems.PrimaryKey pk = new OrderItems.PrimaryKey(1001L, 1);
        OrderItems orderItems = entityManager.find(OrderItems.class, pk);

        assertThat(ReflectionTestUtils.invokeGetterMethod(orderItems, "orderId")).isEqualTo(1001L);
        assertThat(ReflectionTestUtils.invokeGetterMethod(orderItems, "lineNumber")).isEqualTo(1);
        assertThat(ReflectionTestUtils.invokeGetterMethod(orderItems, "itemId")).isEqualTo(1L);
        assertThat(ReflectionTestUtils.invokeGetterMethod(orderItems, "quantity")).isEqualTo(3);
    }

}