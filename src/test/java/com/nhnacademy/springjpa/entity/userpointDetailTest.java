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
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class userpointDetailTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testUserPointDetailEntity() {
        userpointDetail detail = entityManager.find(userpointDetail.class, "admin:20240207145708:1");

        Assertions.assertEquals("admin:20240207145708:1", detail.getUserPointDetailID());
        Assertions.assertEquals("admin", detail.getUsers().getUserId());
        Assertions.assertEquals("DAILY_FIRST_LOGIN", detail.getUserPointChange());
        Assertions.assertEquals(BigDecimal.valueOf(10_000), detail.getUserPointChangeAmount());
        Assertions.assertInstanceOf(LocalDateTime.class, detail.getUserPointChangeDate());
    }
}