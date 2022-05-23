package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.MemberNameOnly;
import com.nhnacademy.springjpa.repository.MemberRepository;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/members")
    // TODO #1: `?page=0&size=3`과 같은 request parameter를 `Pageable` 객체로 받음
    public List<MemberNameOnly> getMembers(Pageable pageable) {
        return memberRepository.getAllBy(pageable).getContent();
    }

}
