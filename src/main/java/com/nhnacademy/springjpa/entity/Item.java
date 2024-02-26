package com.nhnacademy.springjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/*
 *
 * create table if not exists `Items` (
 *   `item_id` bigint not null auto_increment,
 *   `item_name` varchar(40) not null,
 *   `price` bigint not null,
 *
 *   primary key(`item_id`)
 * );
 *
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_name")
    private String itemName;

    private Long price;

}
