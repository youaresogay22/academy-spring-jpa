package com.nhnacademy.springjpa.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
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
public class OrderItems_embed {
    @EmbeddedId
    private PrimaryKey_Embed orderId;

    @Column(name = "item_id")
    private Long itemId;

    private Integer quantity;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    public static class PrimaryKey_Embed implements Serializable {
        @Column(name = "order_id")
        private Long orderId;

        @Column(name = "line_number")
        private Integer lineNumber;
    }
}
