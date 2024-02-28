package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.entity.users;
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

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class UsersRepositoryTest {
    @Autowired
    private UsersRepository userRepository;

    @BeforeEach
    void setUp() {
        users user1 = new users();
        user1.setUserId("user01");
        user1.setUserName("user");
        user1.setUserPassword("1q2w3e");
        user1.setUserBirth("19010102");
        user1.setUserAuth("ROLE_USER");
        user1.setUserPoint(1_000_000);
        user1.setCreatedAt(LocalDateTime.now());
        user1.setLatestLoginAt(LocalDateTime.now().plusHours(1));

        userRepository.saveAndFlush(user1);
    }

    @Test
    void test_Create() {
        Assertions.assertTrue(userRepository.existsById("user01"));
    }

    @Test
    void test_Read() {
        Assertions.assertEquals("1q2w3e", userRepository.findById("user01").orElse(null).getUserPassword());
    }

    @Test
    void test_Update() {
        users user2 = new users();
        user2.setUserId("user01");
        user2.setUserName("user");
        user2.setUserPassword("3e4r5t");
        user2.setUserBirth("19010102");
        user2.setUserAuth("ROLE_USER");
        user2.setUserPoint(1_000_000);
        user2.setCreatedAt(LocalDateTime.now());
        user2.setLatestLoginAt(LocalDateTime.now().plusHours(1));

        userRepository.saveAndFlush(user2);

        Assertions.assertEquals("3e4r5t", userRepository.findById("user01").orElse(null).getUserPassword());
    }

    @Test
    void test_Delete() {
        userRepository.deleteById("user01");

        Assertions.assertFalse(userRepository.existsById("user01"));
    }

    @Test
    void countByUserAuth() {
        Assertions.assertEquals(11L, userRepository.countByUserAuth("ROLE_ADMIN"));
    }

    @Test
    void countByUserId() {
        Assertions.assertEquals(1L, userRepository.countByUserId("user01"));
    }
}