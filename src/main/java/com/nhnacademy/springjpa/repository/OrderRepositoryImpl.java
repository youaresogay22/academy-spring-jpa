package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Item;
import com.nhnacademy.springjpa.entity.Order;
import com.nhnacademy.springjpa.entity.QItem;
import com.nhnacademy.springjpa.entity.QOrder;
import com.nhnacademy.springjpa.entity.QOrderItem;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

// TODO #3: 실습 - querydsl를 이용해 custom repository를 구현하려면 상속받아야 하는 추상 클래스를 작성하세요.
public class OrderRepositoryImpl extends QuerydslRepositorySupport implements OrderRepositoryCustom {
    public OrderRepositoryImpl() {
        // TODO #4: 실습 - 적절한 생성자 호출 구문을 쓰세요.
        super(Order.class);
    }

    // TODO : #5 3번 항목까지 모두 완료하였으면 위의 return null 구문을 삭제하고 아래 주석을 해제하세요.
    @Override
    public List<Item> getItemsHavingOrderItemQuantityGreaterThan(int quantity) {
        QOrder order = QOrder.order;
        QOrderItem orderItem = QOrderItem.orderItem;
        QItem item = QItem.item;

        return from(orderItem)
                .innerJoin(orderItem.order, order)
                .innerJoin(orderItem.item, item)
                .where(orderItem.quantity.gt(quantity))
                .select(item)
                .distinct()
                .fetch();
    }

}
