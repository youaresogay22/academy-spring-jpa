package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Item;
import java.util.List;

// TODO #1: 실습 - 중간 단계 interface의 객체 생성을 막기 위해
//        custom repository interface에 붙여야하는 annotation을 작성하세요.
public interface OrderRepositoryCustom {
    // TODO #2: custom 메서드 선언
    List<Item> getItemsHavingOrderItemQuantityGreaterThan(int quantity);

}
