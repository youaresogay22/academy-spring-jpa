package com.nhnacademy.springjpa.repository;


import com.nhnacademy.springjpa.domain.PointDetailDTO;
import com.nhnacademy.springjpa.entity.userpointDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserPointDetailRepository extends JpaRepository<userpointDetail, String>, UserPointDetailRepositoryCustom {
    List<userpointDetail> findByUsers_UserId(String userId);

    long countByUsers_UserId(String userId);

    long deleteAllByUsers_UserId(String userId);

    // #todo: DTO projection
    // #todo: pagination
    Page<PointDetailDTO> findByUsers_UserId(String userId, Pageable pageable);

//     #todo: Querydsl
//     Optional<userpointDetail> findByPointDetailId(String pointDetailId);

    // #todo: @Query
    @Modifying
    @Query("delete from userpointDetail u where u.userPointDetailID = ?1")
    void terminateFromPointDetailId(String pointDetailId);


    // crudrepo methods
//    int save(userpointDetail pointDetail);

}
