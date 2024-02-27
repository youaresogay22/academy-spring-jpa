package com.nhnacademy.springjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "useraddress")
@NoArgsConstructor
@Getter
@Setter
public class useraddress {
    @Id
    @Column(name = "useraddrID")
    private int userAddrId;

    @Column(name = "useraddress")
    private String userAddress;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private users users;
}
