package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.PointDetailDTO;
import com.nhnacademy.springjpa.repository.UserPointDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/managePointDetail")
public class IndexController {

    UserPointDetailRepository userPointDetailRepository;

    @Autowired
    public IndexController(UserPointDetailRepository userPointDetailRepository) {
        this.userPointDetailRepository = userPointDetailRepository;
    }

    @GetMapping
    public String index(@PageableDefault(size = 10, sort = "userPointChangeDate") Pageable pageable,
                        Model model) {

        String userId = "admin";

        //  Page<PointDetailDTO> pointList = userPointDetailRepository.findByUsers_UserId(userId, PageRequest.of(0, 5));
        Page<PointDetailDTO> pointList = userPointDetailRepository.findByUsers_UserId(userId, pageable);

        int pageNo = pointList.getPageable().getPageNumber();
        int totalPages = pointList.getTotalPages();
        int pageBlock = 5;
        int startBlockPage = ((pageNo) / pageBlock) * pageBlock + 1;
        int endBlockPage = startBlockPage + pageBlock - 1;
        endBlockPage = Math.min(totalPages, endBlockPage);

        model.addAttribute("list", pointList.getContent());
        model.addAttribute("startpageno", startBlockPage);
        model.addAttribute("endpageno", endBlockPage);
        model.addAttribute("totalpages", totalPages);
        model.addAttribute("currentpage", pageNo);

        model.addAttribute("userId", userId);

        return "index";
    }

}
