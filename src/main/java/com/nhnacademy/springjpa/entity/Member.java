package com.nhnacademy.springjpa.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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

    @OneToOne(mappedBy = "member")
    private Locker locker;

    // TODO #1: 일대다 연관관계 설정
    @OneToMany
    @JoinColumn(name = "member_id")
    private List<MemberDetail> memberDetails;

}
