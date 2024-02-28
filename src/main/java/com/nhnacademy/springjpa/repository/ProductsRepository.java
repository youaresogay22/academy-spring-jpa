package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, String> {
}
