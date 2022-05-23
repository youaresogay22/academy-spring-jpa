package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.MemberDto;
import com.nhnacademy.springjpa.domain.MemberNameOnly;
import com.nhnacademy.springjpa.entity.Member;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
    MemberNameOnly queryById(String id);

    List<MemberDto> findByUserName(String userName);

    // TODO #2: Pageable을 인자로 받아 DTO Projection 결과를 Page 객체로 반환하는 repository method 선언.
    Page<MemberNameOnly> getAllBy(Pageable pageable);

}
