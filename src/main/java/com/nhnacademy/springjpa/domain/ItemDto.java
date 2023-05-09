package com.nhnacademy.springjpa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;

// TODO #2: test case를 통과할 수 있도록 `ItemDto`를 작성하세요.
public interface ItemDto {
    String getItemName();

    List<OrderItemDto> getOrderItems();


    interface OrderItemDto {
        int getQuantity();

        OrderDto getOrder();

    }

    interface OrderDto {
        @JsonFormat(pattern = "yyyyMMdd")
        Date getOrderDate();

    }

}
