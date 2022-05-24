package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.MemberNameOnly;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    // TODO #5: `GET /members?page=0&size=3` 와 같은 요청을 처리하도록 아래 코드를 완성하세요.
    @GetMapping("/members")
    public List<MemberNameOnly> getMembers() {
        return null;
    }

}
