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

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class ProductsTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testProductEntity() {
        Products product = entityManager.find(Products.class, "1");

        Assertions.assertNotNull(product.getProductID());
        Assertions.assertNotNull(product.getModelNumber());
        Assertions.assertNotNull(product.getModelName());
        Assertions.assertNotNull(product.getProductThumbnail());
        Assertions.assertNotNull(product.getProductImage());
        Assertions.assertNotNull(product.getUnitCost());
        Assertions.assertInstanceOf(Integer.class, product.getUnitQuantity());
        Assertions.assertNotNull(product.getDescription());
    }

}