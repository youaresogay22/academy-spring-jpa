package com.nhnacademy.springjpa.domain;

import java.util.List;

// TODO #4: 중첩 구조를 가지는 Member DTO interface
public interface MemberDto {
    String getUserName();
    List<MemberDetailDto> getMemberDetails();

    interface MemberDetailDto {
        String getType();
        String getDescription();
    }

}
