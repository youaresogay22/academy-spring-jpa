package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.entity.Products;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class ProductsRepositoryTest {
    @Autowired
    private ProductsRepository productsRepository;

    @BeforeEach
    void setUp() {
        Products product = new Products();

        product.setProductId("345");
        product.setModelNumber("100");
        product.setModelName("m.name");
        product.setProductThumbnail("thum");
        product.setProductImage("img");
        product.setUnitCost(BigDecimal.valueOf(777));
        product.setUnitQuantity(42);
        product.setDescription("345");

        productsRepository.saveAndFlush(product);
    }

    @Test
    void test_Create() {
        Assertions.assertTrue(productsRepository.existsById("345"));
    }

    @Test
    void test_Read() {
        Assertions.assertEquals("m.name", productsRepository.findById("345").orElse(null).getModelName());
    }

    @Test
    void test_Update() {
        Products product = new Products();

        product.setProductId("345");
        product.setModelNumber("100");
        product.setModelName("m.name2");
        product.setProductThumbnail("thum");
        product.setProductImage("img");
        product.setUnitCost(BigDecimal.valueOf(777));
        product.setUnitQuantity(42);
        product.setDescription("desc");

        productsRepository.saveAndFlush(product);

        Assertions.assertEquals("m.name2", productsRepository.findById("345").orElse(null).getModelName());
    }

    @Test
    void test_Delete() {
        productsRepository.deleteById("345");
        Assertions.assertFalse(productsRepository.existsById("345"));
    }

    @Test
    void findByModelNumber() {
        Assertions.assertNotEquals(0, productsRepository.findByModelNumber("100").size());
    }

    @Test
    void findByModelName() {
        Assertions.assertNotEquals(0, productsRepository.findByModelName("m.name2"));
    }

    @Test
    void findByDescription() {
        Assertions.assertNotEquals(0, productsRepository.findByDescription("desc"));
    }

    @Test
    void countByProductID() {
        Assertions.assertEquals(1, productsRepository.countByProductId("345"));
    }

    @Test
    void findAll() {
        Assertions.assertEquals(9, productsRepository.findAll(PageRequest.of(0, 3)).getTotalElements());
    }
}