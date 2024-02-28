package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.MemberDto;
import com.nhnacademy.springjpa.domain.MemberNameOnly;
import com.nhnacademy.springjpa.entity.Member;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, String> {
    MemberNameOnly queryById(String id);

    List<MemberDto> findByUserName(String userName);

    Page<MemberNameOnly> getAllBy(Pageable pageable);

    // TODO : use join fetch
    @Query("select m from Member m inner join fetch m.locker  inner join fetch m.memberDetails")
    List<Member> getMembersWithAssociation();

}
