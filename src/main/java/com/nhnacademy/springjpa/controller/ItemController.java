package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.ItemDto;
import com.nhnacademy.springjpa.entity.Item;
import com.nhnacademy.springjpa.repository.ItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // TODO #4: DTO를 반환하는 repository method를 호출해서 DTO로 응답
    @GetMapping("/v1/items/{itemId}")
    public ItemDto getItem1(@PathVariable("itemId") Long itemId) {
        return itemRepository.findByItemId(itemId);
    }

    // TODO #5: DomainClassConverter를 이용해서 path variable로 Entity를 받음
    @GetMapping("/v2/items/{itemId}")
    public ItemDto getItem2(@PathVariable("itemId") Item item) {
        return new ItemDto() {
            @Override
            public String getName() {
                return item.getItemName();
            }

            @Override
            public Long getPrice() {
                return item.getPrice();
            }
        };
    }

}
