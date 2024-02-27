package com.nhnacademy.springjpa.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

// TODO #2: `Locker` Entity
@Getter
@Setter
@Entity
@Table(name = "Lockers")
public class Locker {
    @Id
    @Column(name = "locker_id")
    private Long id;

    @Column(name = "locker_name")
    private String name;

    //fk 없으므로 주인  설정
    @OneToOne(mappedBy = "locker")
    private Member member;

}
