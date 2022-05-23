package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO #1: `ItemRepository`
public interface ItemRepository extends JpaRepository<Item, Long> {
}
