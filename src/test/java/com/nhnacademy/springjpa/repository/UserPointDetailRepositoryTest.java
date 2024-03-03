package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.entity.userpointDetail;
import com.nhnacademy.springjpa.entity.users;
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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class UserPointDetailRepositoryTest {
    @Autowired
    private UserPointDetailRepository userPointDetailRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        users user = entityManager.find(users.class, "admin");
        userpointDetail detail = new userpointDetail();

        detail.setUserPointDetailID("test id");
        detail.setUsers(user);
        detail.setUserPointChange("DAILY_FIRST_LOGIN");
        detail.setUserPointChangeAmount(BigDecimal.valueOf(100_000));
        detail.setUserPointChangeDate(LocalDateTime.now());

        userPointDetailRepository.saveAndFlush(detail);
    }

    @Test
    void test_Create() {
        Assertions.assertTrue(userPointDetailRepository.existsById("test id"));
    }

    @Test
    void test_Read() {
        Assertions.assertEquals("admin", userPointDetailRepository.findById("test id").orElse(null).getUsers().getUserId());
    }

    @Test
    void test_Update() {
        users user = entityManager.find(users.class, "user");
        userpointDetail detail = new userpointDetail();

        detail.setUserPointDetailID("test id");
        detail.setUsers(user);
        detail.setUserPointChange("DAILY_FIRST_LOGIN");
        detail.setUserPointChangeAmount(BigDecimal.valueOf(100_000));
        detail.setUserPointChangeDate(LocalDateTime.now());

        userPointDetailRepository.saveAndFlush(detail);

        Assertions.assertEquals("user", userPointDetailRepository.findById("test id").orElse(null).getUsers().getUserId());
    }

    @Test
    void test_Delete() {
        userPointDetailRepository.deleteById("test id");
        Assertions.assertFalse(userPointDetailRepository.existsById("test id"));
    }

    @Test
    void findByUsers_UserId_LIST() {
        Assertions.assertNotEquals(0, userPointDetailRepository.findByUsers_UserId("admin").size());
    }

    @Test
    void findByUsers_UserId_Page() {
        Assertions.assertEquals(63, userPointDetailRepository.findByUsers_UserId("admin", PageRequest.of(0, 3)).getTotalElements());
    }

    @Test
    void countByUsers_UserId() {
        Assertions.assertNotEquals(0, userPointDetailRepository.countByUsers_UserId("admin"));
    }

    @Test
    void deleteAllByUsers_UserId() {
        userPointDetailRepository.deleteAllByUsers_UserId("admin");
        Assertions.assertEquals(0, userPointDetailRepository.countByUsers_UserId("admin"));
    }

    @Test
    void findByPointDetailId() {
        Optional<userpointDetail> test = userPointDetailRepository.getOneFromPointDetailId("test id");
        Assertions.assertEquals("test id", test.get().getUserPointDetailID());
    }

    @Test
    void terminateFromPointDetailId() {
        userPointDetailRepository.terminateFromPointDetailId("test id");
        Assertions.assertFalse(userPointDetailRepository.existsById("test id"));
    }
}