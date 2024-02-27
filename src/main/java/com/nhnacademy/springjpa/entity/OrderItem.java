package com.nhnacademy.springjpa.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
    create table if not exists `OrderItems` (
        `order_id` bigint not null,
        `line_number` integer not null,
        `item_id` bigint not null,
        `quantity` integer not null,

        primary key(`order_id`, `line_number`)
    );
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "OrdersItems")
public class OrderItem {
    @EmbeddedId
    private Pk pk;

    @Column(name = "item_id", insertable = false, updatable = false)
    private Long itemId;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "order_id")
        private Long orderId;

        @Column(name = "line_number")
        private Integer lineNumber;
    }

}
