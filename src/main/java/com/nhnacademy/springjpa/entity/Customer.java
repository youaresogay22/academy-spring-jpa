package com.nhnacademy.springjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_password")
    private String customerPassword;

    @Column(name = "customer_birth")
    private String customerBirth;

    @Column(name = "customer_auth")
    private String customerAuth;

    @Column(name = "customer_point")
    private int customerPoint;

    @Column(name = "signedup_at")
    private LocalDateTime signedUpAt;

    @Column(name = "latest_login_at")
    private LocalDateTime latestLoginAt;

}
