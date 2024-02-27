package com.nhnacademy.springjpa.entity;

import static org.assertj.core.api.Assertions.assertThat;

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

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
public class EntityManagerTest {
    @PersistenceContext
    EntityManager entityManager;

    // TODO #3: 다음 테스트를 실행하면 수행될 쿼리는?
    // 아무것도 실행되지 않음, entitymanager가 flush() 하지 않았기 때문
    // 쿼리는 작성되었지만 flush() 되어야 커밋됨
    // 당연히 DB에 저장도 안됨
    @Test
    void test1() {
        User user1 = new User();
        user1.setId("newUser");
        user1.setPassword("abcde");

        entityManager.persist(user1);

        User user2 = entityManager.find(User.class, "newUser");
        assertThat(user2).isEqualTo(user1);
    }

    // TODO #4: 다음 테스트를 실행하면 수행될 쿼리는?
    // insert into users (newUser, abcde) 만 실행됨
    // select 는 실행되지 않음, 엔티티매니저가 1차 쿼리처럼 동작하기 때문
    @Test
    void test2() {
        User user1 = new User();
        user1.setId("newUser");
        user1.setPassword("abcde");

        entityManager.persist(user1);
        entityManager.flush();          // <--

        User user2 = entityManager.find(User.class, "newUser");
        assertThat(user2).isEqualTo(user1);
    }

    // TODO #5: 다음 테스트를 실행하면 수행될 쿼리는?
    // insert, update
    // assertThat(user2).isEqualTo(user1); 의 경우, 원래는 같지 않다.
    // 그러나 엔티티매니저가 primary key로 검색한 경우 이미 영속된 객체가 있으면 그것을 리턴하기때문에 같음 결과가 나온다.
    // print 문의 경우,
    // ---1
    // ---2
    // insert into ... 순으로 출력된다.
    // flush() 가 실행될 때 쿼리가 실제로 실행되기 때문.
    @Test
    void test3() {
        User user1 = new User();
        user1.setId("newUser");
        user1.setPassword("abcde");

        entityManager.persist(user1);
        System.out.println("---------1");
        User user2 = entityManager.find(User.class, "newUser");
        assertThat(user2).isEqualTo(user1);

        user2.setPassword("fghij");
        System.out.println("---------1");
        entityManager.flush();
    }

    // TODO #6: 다음 테스트를 실행하면 수행될 쿼리는?
    // select 한번, 이후로는 엔티티매니저가 영속된 객체를 계속 리턴한다.
    // primary key가 유니크한 필드이기 때문에 가능하다
    @Test
    void test4() {
        User user1 = entityManager.find(User.class, "admin");
        User user2 = entityManager.find(User.class, "admin");
        User user3 = entityManager.find(User.class, "admin");
        User user4 = entityManager.find(User.class, "admin");
        User user5 = entityManager.find(User.class, "admin");

        assertThat(user1).isEqualTo(user2);
        assertThat(user1).isEqualTo(user3);
        assertThat(user1).isEqualTo(user4);
        assertThat(user1).isEqualTo(user5);

    }


}
