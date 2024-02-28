package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class ProductsRepositoryTest {
    @Test
    void test_Create() {
    }

    @Test
    void test_Read() {
    }

    @Test
    void test_Update() {
    }

    @Test
    void test_Delete() {
    }

    @Test
    void findByModelNumber() {
    }

    @Test
    void findByModelName() {
    }

    @Test
    void findByDescription() {
    }

    @Test
    void countByProductID() {
    }

    @Test
    void findAll() {
    }
}