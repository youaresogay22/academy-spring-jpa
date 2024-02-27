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
class useraddressTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testUserAddressEntity() {
        users user = entityManager.find(users.class, "admin");

        useraddress useraddress1 = new useraddress();

        useraddress1.setUserAddrId(100);
        useraddress1.setUserAddress("주소");
        useraddress1.setUsers(user);

        entityManager.persist(useraddress1);
        entityManager.flush();

        useraddress useraddress2 = entityManager.find(useraddress.class, 100);

        Assertions.assertEquals(100, useraddress2.getUserAddrId());
        Assertions.assertEquals("주소", useraddress2.getUserAddress());
        Assertions.assertEquals(user, useraddress2.getUsers());
    }
}