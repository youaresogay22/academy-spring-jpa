package com.nhnacademy.springjpa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;
import java.util.List;

// TODO #2: test case를 통과할 수 있도록 `ItemDto`를 작성하세요.
@JsonPropertyOrder({"itemName", "orderItems", "order", "orderDate", "quantity"})
public interface ItemDto {
    String getItemName();

    List<OrderItemDto> getOrderItems();

    interface OrderItemDto {
        OrderDto getOrder();

        Integer getQuantity();
    }

    interface OrderDto {
        @JsonFormat(pattern = "yyyyMMdd")
        Date getOrderDate();

    }
}
