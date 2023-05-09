package com.nhnacademy.springjpa.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import org.junit.jupiter.api.BeforeEach;
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
public class ItemRepositoryTest3 {
    @Autowired
    private ItemRepository itemRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    public void setUp() {
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    // TODO #3: test case
    @Test
    public void test() throws Exception {
        assertThat(objectMapper.writeValueAsString(itemRepository.findAllBy()))
            .isEqualTo("[{\"itemName\":\"apple\",\"orderItems\":[{\"order\":{\"orderDate\":\"20180823\"},\"quantity\":3}]},"
                + "{\"itemName\":\"grape\",\"orderItems\":[{\"order\":{\"orderDate\":\"20180823\"},\"quantity\":1}]},"
                + "{\"itemName\":\"banana\",\"orderItems\":[{\"order\":{\"orderDate\":\"20180823\"},\"quantity\":2}]},"
                + "{\"itemName\":\"cherry\",\"orderItems\":[{\"order\":{\"orderDate\":\"20180824\"},\"quantity\":1}]},"
                + "{\"itemName\":\"kiwi\",\"orderItems\":[{\"order\":{\"orderDate\":\"20180824\"},\"quantity\":1}]},"
                + "{\"itemName\":\"lemon\",\"orderItems\":[{\"order\":{\"orderDate\":\"20180824\"},\"quantity\":2}]},"
                + "{\"itemName\":\"lime\",\"orderItems\":[{\"order\":{\"orderDate\":\"20180824\"},\"quantity\":1}]},"
                + "{\"itemName\":\"mango\",\"orderItems\":[{\"order\":{\"orderDate\":\"20180824\"},\"quantity\":5}]},"
                + "{\"itemName\":\"orange\",\"orderItems\":[{\"order\":{\"orderDate\":\"20180824\"},\"quantity\":1}]},"
                + "{\"itemName\":\"peach\",\"orderItems\":[]},"
                + "{\"itemName\":\"melon\",\"orderItems\":[]}]");
    }

}
