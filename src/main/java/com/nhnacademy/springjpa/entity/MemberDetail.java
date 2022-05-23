package com.nhnacademy.springjpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MemberDetails")
public class MemberDetail {
    @Id
    @Column(name = "member_detail_id")
    private Long id;

    private String type;

    private String description;

    // TODO #1: 영속성 전이 설정
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "member_id")
    private Member member;

}
