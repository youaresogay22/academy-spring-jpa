package com.nhnacademy.springjpa.repository;


import com.nhnacademy.springjpa.entity.userpointDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

interface UserPointDetailRepository extends JpaRepository<userpointDetail, String> {
    Optional<userpointDetail> findByUsers_UserId(String userId);

    long countByUsers_UserId(String userId);

    long deleteByUsers_UserId(String userId);

    Page<userpointDetail> pageAll(int page, int pageSize, String userId);

    // crudrepo methods
//    int save(userpointDetail pointDetail);
//    Optional<userpointDetail> findByPointDetailId(String pointDetailId);
//    int deleteByPointDetailId(String pointDetailId);
}
