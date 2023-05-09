package com.nhnacademy.springjpa.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
    @ContextConfiguration(classes = RootConfig.class),
    @ContextConfiguration(classes = WebConfig.class)
})
public class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    // TODO #2: test case 를 통과시키세요.
    @Test
    public void test() throws Exception {
        Date orderDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-08-24 00:00:00");
        assertThat(orderRepository.findByOrderDateAfter(orderDate)).isNotEmpty().hasSize(1);
        assertThat(orderRepository.getOrdersHavingOrderDateAfter(orderDate)).isNotEmpty().hasSize(1);
    }

}
