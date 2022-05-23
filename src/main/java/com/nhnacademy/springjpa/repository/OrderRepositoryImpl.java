package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Item;
import java.util.List;

// TODO #3: 실습 - querydsl를 이용해 custom repository를 구현하려면 상속받아야 하는 추상 클래스를 작성하세요.
public class OrderRepositoryImpl extends Object/*???*/ {
    public OrderRepositoryImpl() {
        // TODO #4: 실습 - 적절한 생성자 호출 구문을 쓰세요.
    }

    @Override
    public List<Item> getItemsHavingOrderItemQuantityGreaterThan(int quantity) {
        return null;
        // TODO : #5 3번 항목까지 모두 완료하였으면 위의 return null 구문을 삭제하고 아래 주석을 해제하세요.
        /*
        QOrder order = QOrder.order;
        QOrderItem orderItem = QOrderItem.orderItem;
        QItem item = QItem.item;

        return from(order)
                .innerJoin(order.orderItems, orderItem)
                .innerJoin(orderItem.item, item)
                .where(orderItem.quantity.gt(quantity))
                .select(item)
                .distinct()
                .fetch();
        */
    }

}
