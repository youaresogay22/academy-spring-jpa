package com.nhnacademy.springjpa.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

//`order_id` bigint not null,
//        `line_number` integer not null,
//        `item_id` bigint not null,
//        `quantity` integer not null,
//
//primary key(`order_id`, `line_number`)
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "OrderItems")
@IdClass(OrderItems.PrimaryKey.class)
public class OrderItems {
    @Id
    @Column(name = "order_id")
    private Long orderId;

    @Id
    @Column(name = "line_number")
    private Integer lineNumber;

    @Column(name = "item_id")
    private Long itemId;

    private Integer quantity;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    public static class PrimaryKey implements Serializable {
        private Long orderId;

        private Integer lineNumber;
    }
}
