package com.nhnacademy.springjpa.repository;


import com.nhnacademy.springjpa.entity.userpointDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface UserPointDetailRepository extends JpaRepository<userpointDetail, String> {
    List<userpointDetail> findByUsers_UserId(String userId);

    long countByUsers_UserId(String userId);

    long deleteAllByUsers_UserId(String userId);

    Page<userpointDetail> findByUsers_UserId(String userId, Pageable pageable);

    // crudrepo methods
//    int save(userpointDetail pointDetail);
//    Optional<userpointDetail> findByPointDetailId(String pointDetailId);
//    int deleteByPointDetailId(String pointDetailId);
}
