package com.nhnacademy.springjpa.entity;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO #4: 아래 `@Disabled` 어노테이션을 삭제하고 테스트를 통과시키세요.
 */
@Disabled("temporary")
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
    @ContextConfiguration(classes = RootConfig.class),
    @ContextConfiguration(classes = WebConfig.class)
})
public class EntityMappingTest {
    @PersistenceContext
    EntityManager entityManager;


    @Test
    public void test() {
        Question question1 = entityManager.find(Question.class, 1L);
        assertThat(ReflectionTestUtils.invokeGetterMethod(question1, "questionId")).isEqualTo(1L);

        Answer answer1 = entityManager.find(Answer.class, 1L);
        assertThat(ReflectionTestUtils.invokeGetterMethod(answer1, "answerId")).isEqualTo(1L);

        Answer answer2 = entityManager.find(Answer.class, 2L);
        assertThat(ReflectionTestUtils.invokeGetterMethod(answer2, "answerId")).isEqualTo(2L);

        Answer answer3 = new Answer();
        ReflectionTestUtils.invokeSetterMethod(answer3, "questionId", 1L);
        ReflectionTestUtils.invokeSetterMethod(answer3, "content", "또 또 답변");
        ReflectionTestUtils.invokeSetterMethod(answer3, "createdAt", LocalDateTime.now());
        entityManager.persist(answer3);
    }

}
