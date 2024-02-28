package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface ProductsRepository extends JpaRepository<Products, String> {
    Optional<Products> findByModelNumber(String modelNumber);

    Optional<Products> findByModelName(String modelName);

    Optional<Products> findByDescription(String description);

    //#todo: 페이지네이션
    Page<Products> pageAll(int page, int pageSize);

//       crudRepo 에서 제공
//    save(Products product);
//    int update(Products product);
//    int updateByProductId(String productId);
//    int deleteByProductId(String productId);
//    int countAll();
//    int countByProductId(String productId);

}
