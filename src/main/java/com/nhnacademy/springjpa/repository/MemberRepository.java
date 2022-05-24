package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.MemberDto;
import com.nhnacademy.springjpa.domain.MemberNameOnly;
import com.nhnacademy.springjpa.entity.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
    // TODO #2: Entity가 아니라 Dto를 반환하는 repository method
    MemberNameOnly queryById(String id);

    // TODO #5: 중첩구조를 가지는 Dto를 반환하는 repository method
    List<MemberDto> findByUserName(String userName);

}
