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

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class OrderItems_embedTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testOrderItems_embed() {
        OrderItems_embed.PrimaryKey_Embed pk = new OrderItems_embed.PrimaryKey_Embed(1001L, 2);
        OrderItems_embed orderItems = entityManager.find(OrderItems_embed.class, pk);

        assertThat(ReflectionTestUtils.invokeGetterMethod(orderItems.getOrderId(), "orderId")).isEqualTo(1001L);
        assertThat(ReflectionTestUtils.invokeGetterMethod(orderItems.getOrderId(), "lineNumber")).isEqualTo(2);
        assertThat(ReflectionTestUtils.invokeGetterMethod(orderItems, "itemId")).isEqualTo(2L);
        assertThat(ReflectionTestUtils.invokeGetterMethod(orderItems, "quantity")).isEqualTo(1);
    }
}