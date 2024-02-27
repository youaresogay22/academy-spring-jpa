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
class customerTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testUsersEntity() {
        Customer customer = entityManager.find(Customer.class, "admin");

        Assertions.assertEquals("admin", customer.getCustomerId());
        Assertions.assertEquals("관리자", customer.getCustomerName());
        Assertions.assertEquals("12345", customer.getCustomerPassword());
        Assertions.assertEquals("19000101", customer.getCustomerBirth());
        Assertions.assertEquals("ROLE_ADMIN", customer.getCustomerAuth());
        Assertions.assertEquals(1_560_000, customer.getCustomerPoint());
        Assertions.assertInstanceOf(LocalDateTime.class, customer.getSignedUpAt());
        Assertions.assertInstanceOf(LocalDateTime.class, customer.getLatestLoginAt());
    }

}