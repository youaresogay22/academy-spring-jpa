package com.nhnacademy.springjpa.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

// TODO #1: `Member` Entity
@Getter
@Setter
@Entity
@Table(name = "Members")
public class Member {
    @Id
    @Column(name = "member_id")
    private String id;

    @Column(name = "user_name")
    private String userName;

    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;

}
