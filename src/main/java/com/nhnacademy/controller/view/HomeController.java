package com.nhnacademy.controller.view;

import com.nhnacademy.domain.PageDTO;
import com.nhnacademy.entity.Resident;
import com.nhnacademy.service.ResidentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class HomeController {

    private final ResidentService residentService;

    @GetMapping
    public String homeController(@PageableDefault(size = 20, sort = "residentSerialNumber", direction = Sort.Direction.DESC) Pageable pageable,
                                 Model model) {

        Page<Resident> residents = residentService.findAll(pageable);
        PageDTO pageDTO = new PageDTO(pageable.getPageNumber(), pageable.getPageSize(), residents.getTotalElements());


        model.addAttribute("residents", residents.getContent());
        model.addAttribute("page", pageDTO);

        return "index";
    }



}
