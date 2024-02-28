package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.entity.Categories;
import com.nhnacademy.springjpa.entity.Products;
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

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class CategoriesRepositoryTest {
    @Autowired
    private CategoriesRepository categoriesRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        Products product = entityManager.find(Products.class, "1");

        Categories category = new Categories();

        category.setCategoryId(7);
        category.setCategoryName("name");
        category.setProduct(product);

        categoriesRepository.saveAndFlush(category);
    }

    @Test
    void test_Create() {
        Assertions.assertTrue(categoriesRepository.existsById(7));
    }

    @Test
    void test_Read() {
        Assertions.assertEquals("name", categoriesRepository.findById(7).orElse(null).getCategoryName());
    }

    @Test
    void test_Update() {
        Products product = entityManager.find(Products.class, "2");

        Categories category = new Categories();

        category.setCategoryId(7);
        category.setCategoryName("name");
        category.setProduct(product);

        categoriesRepository.saveAndFlush(category);

        Assertions.assertEquals("테스트 상품 2", categoriesRepository.findById(7).orElse(null).getProduct().getModelName());
    }

    @Test
    void test_Delete() {
        categoriesRepository.deleteById(7);

        Assertions.assertFalse(categoriesRepository.existsById(7));
    }

}