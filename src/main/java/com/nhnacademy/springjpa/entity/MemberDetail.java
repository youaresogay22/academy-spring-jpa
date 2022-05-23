package com.nhnacademy.springjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

    // TODO #2: 다대일 연관관계 삭제

}
