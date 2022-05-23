package com.nhnacademy.springjpa.entity;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

// TODO #3: test case
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
    @ContextConfiguration(classes = RootConfig.class),
    @ContextConfiguration(classes = WebConfig.class)
})
public class OneToManyTest {
    @PersistenceContext
    EntityManager entityManager;

    @Test
    void test() {
        MemberDetail memberDetail1 = new MemberDetail();
        memberDetail1.setId(1L);
        memberDetail1.setType("type1");
        memberDetail1.setDescription("...");

        entityManager.persist(memberDetail1);

        MemberDetail memberDetail2 = new MemberDetail();
        memberDetail2.setId(2L);
        memberDetail2.setType("type2");
        memberDetail2.setDescription("설명 설명");

        entityManager.persist(memberDetail2);

        List<MemberDetail> memberDetails = new ArrayList<>();
        memberDetails.add(memberDetail1);
        memberDetails.add(memberDetail2);

        Member member = new Member();
        member.setId("nhn");
        member.setUserName("academy");
        member.setMemberDetails(memberDetails);

        entityManager.persist(member);

        entityManager.flush();
    }

}
