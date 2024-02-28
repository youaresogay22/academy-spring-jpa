package com.nhnacademy.springjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

// TODO #4: `Enrollments` 테이블과 맵핑될 `Enrollment` Entity 클래스
//          Entity 맵핑과 연관관계 맵핑을 하세요.
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Enrollments")
public class Enrollment {
    @EmbeddedId
    private Pk pk;

    @MapsId("studentId")
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @MapsId("classId")
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Clazz clazz;

    @Column(name = "enrolled_at")
    private LocalDateTime enrolledAt;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "student_id")
        private long studentId;

        @Column(name = "class_id")
        private long classId;
    }

}
