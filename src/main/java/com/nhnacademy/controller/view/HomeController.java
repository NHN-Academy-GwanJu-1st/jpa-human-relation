package com.nhnacademy.controller.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.domain.GitHub;
import com.nhnacademy.domain.GithubUserInfo;
import com.nhnacademy.entity.Resident;
import com.nhnacademy.service.CustomUserDetailsService;
import com.nhnacademy.service.FamilyRelationshipService;
import com.nhnacademy.service.GithubService;
import com.nhnacademy.service.ResidentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class HomeController {

    private final ResidentService residentService;
    private final FamilyRelationshipService familyRelationshipService;
    private final GithubService githubService;

    @GetMapping
    public String home(@SessionAttribute(name = "username", required = false) String username,
                       Model model) {

        if (Objects.nonNull(username)) {
            Resident resident = residentService.findByResidentId(username);
            Long residentSerialNumber = resident.getResidentSerialNumber();
            model.addAttribute("name", resident.getName());
            model.addAttribute("email", resident.getEmail());
            model.addAttribute("resident", residentService.findById(residentSerialNumber));
            model.addAttribute("familyList", familyRelationshipService.getFamilyRelationNumberAndCode(residentSerialNumber));
        }

        return "index";
    }

    @GetMapping("/login/oauth2/code/github")
    public void githubCallback(@RequestParam(name = "code") String code,
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                 Model model) throws IOException, ServletException {
        GithubUserInfo githubUserInfo = githubService.githubOauthCallback(code);

        Resident resident = residentService.findByEmail(githubUserInfo.getEmail());

        githubService.registerAuthenticationToken(resident, request, response);
    }
}
