package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Order;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderDateAfter(Date orderDate);

    // TODO #1: `@Query`를 이용해서 위의 `findByOrderDateAfter()` 메서드와 동일한 기능을 하도록 JPQL을 작성하세요.
    @Query("select o from Order o")
    List<Order> getOrdersHavingOrderDateAfter(Date orderDate);

}
