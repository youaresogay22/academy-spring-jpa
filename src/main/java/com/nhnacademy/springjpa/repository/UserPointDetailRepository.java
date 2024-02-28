package com.nhnacademy.springjpa.repository;


import com.nhnacademy.springjpa.entity.userpointDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface UserPointDetailRepository extends JpaRepository<userpointDetail, String> {
    public int save(PointDetail pointDetail) ;

    
    public int deleteByPointDetailId(String pointDetailId);

    
    public int deleteByUserId(String userId) ;
    
    public Optional<PointDetail> findByPointDetailId(String pointDetailId) ;


    
    public Optional<PointDetail> findByUserId(String userId) ;
    
    public Page<PointDetail> pageAll(int page, int pageSize, String userId);


    
    public int countByUserId(String userId);
    public int deleteDetailQuery(String userId, String sql) ;

    public Optional<PointDetail> findDetailQuery(String userId, String sql) ;
