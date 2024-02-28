package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
}
