package com.nhnacademy.springjpa.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * TODO #3: `Answers` 테이블과 맵핑될 `Answer` Entity 클래스를 작성하세요.
 */
@Getter
@Setter
@Entity
@Table(name = "Answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long answerId;

    @Column(name = "question_id")
    private Long questionId;

    private String content;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
