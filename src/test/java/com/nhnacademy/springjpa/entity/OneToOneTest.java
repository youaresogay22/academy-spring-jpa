package com.nhnacademy.springjpa.entity;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

// TODO #4: test case 수정
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
    @ContextConfiguration(classes = RootConfig.class),
    @ContextConfiguration(classes = WebConfig.class)
})
public class OneToOneTest {
    @PersistenceContext
    EntityManager entityManager;

    @Test
    void test() {
        Member member = new Member();
        member.setId("nhn");
        member.setUserName("academy");

        entityManager.persist(member);

        Locker locker = new Locker();
        locker.setId(1L);
        locker.setName("No.1 Locker");
        locker.setMember(member);

        entityManager.persist(locker);

        entityManager.flush();
    }

}