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

// TODO #4: test case
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
        Locker locker = new Locker();
        locker.setId(1L);
        locker.setName("No.1 Locker");

        entityManager.persist(locker);

        Member member = new Member();
        member.setId("nhn");
        member.setUserName("academy");
        member.setLocker(locker); // 연관관계 생성

        entityManager.persist(member);

        entityManager.flush();
    }
//      실행 결과: insert into members locker_id, username, member_id
//      만약 locker 객체를 persist 하지 않으면 insert 하기전에 locker id를 찾기 위해 데이터베이스에서 select 한다.
//      그러나 db에 새 객체가 이미 존재할 리 없으므로, sql 에러가 발생한다.
    // cascade = persist 속성 지정한 경우,member insert 하기 전 locker에 insert 한 뒤 member insert 한다.
}
