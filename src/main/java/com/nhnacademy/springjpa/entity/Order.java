package com.nhnacademy.springjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

// TODO #1: `Orders` 테이블과 맵핑될 `Order` Entity 클래스를 작성하세요.
/*
 * create table if not exists `Orders` (
 *   `order_id` bigint not null auto_increment,
 *   `order_date` timestamp not null,
 *
 *   primary key(`order_id`)
 * );
 *
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date")
    private Date orderDate;

}
