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
class ShoppingCartTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testShoppingCartEntity() {
        Products product = entityManager.find(Products.class, "1");

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setRecordId(101);
        shoppingCart.setCartId("cartID");
        shoppingCart.setQuantity(10);
        shoppingCart.setProduct(product);
        shoppingCart.setDateCreated(LocalDateTime.now());

        entityManager.persist(shoppingCart);
        entityManager.flush();

        ShoppingCart shoppingCart2 = entityManager.find(ShoppingCart.class, 101);

        Assertions.assertEquals(101, shoppingCart2.getRecordId());
        Assertions.assertEquals("cartID", shoppingCart2.getCartId());
        Assertions.assertEquals(10, shoppingCart2.getQuantity());
        Assertions.assertEquals("1", shoppingCart2.getProduct().getProductId());
        Assertions.assertInstanceOf(LocalDateTime.class, shoppingCart2.getDateCreated());
    }
}