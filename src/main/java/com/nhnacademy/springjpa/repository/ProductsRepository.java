package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, String> {
    List<Products> findByModelNumber(String modelNumber);

    List<Products> findByModelName(String modelName);

    List<Products> findByDescription(String description);

    long countByProductId(String productId);

    Page<Products> findAll(Pageable pageable);
    
//    save(Products product);
//    int update(Products product);
//    int updateByProductId(String productId);
//    int deleteByProductId(String productId);
//    int countAll();

}
