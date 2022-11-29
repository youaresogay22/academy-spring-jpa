package com.nhnacademy.springjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Students")
public class Student {
    @Id
    @Column(name = "student_id")
    private Long id;

    @Column(name = "student_name")
    private String name;

}
