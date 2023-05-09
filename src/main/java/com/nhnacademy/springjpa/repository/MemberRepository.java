package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.MemberDto;
import com.nhnacademy.springjpa.domain.MemberNameOnly;
import com.nhnacademy.springjpa.entity.Member;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String>, MemberRepositoryCustom {
    MemberNameOnly queryById(String id);

    List<MemberDto> findByUserName(String userName);

    Page<MemberNameOnly> getAllBy(Pageable pageable);


}
