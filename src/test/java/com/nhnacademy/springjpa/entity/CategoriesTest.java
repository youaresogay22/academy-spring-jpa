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
class CategoriesTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testCategoriesEntity() {
        Products product = entityManager.find(Products.class, "1");

        Categories categories = new Categories();

        categories.setCategoryID(102);
        categories.setCategoryName("이름");
        categories.setProduct(product);

        entityManager.persist(categories);
        entityManager.flush();

        Categories categories2 = entityManager.find(Categories.class, 102);

        Assertions.assertEquals(102, categories2.getCategoryID());
        Assertions.assertEquals("이름", categories2.getCategoryName());
        Assertions.assertEquals("1", categories2.getProduct().getProductID());
    }
}