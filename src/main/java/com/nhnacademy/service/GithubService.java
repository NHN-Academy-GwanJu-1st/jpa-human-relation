package com.nhnacademy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.auth.LoginSuccessHandler;
import com.nhnacademy.domain.GitHub;
import com.nhnacademy.domain.GithubUserInfo;
import com.nhnacademy.entity.Resident;
import com.nhnacademy.repository.ResidentRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.*;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@Service
public class GithubService {


    private final RedisTemplate<String, String> redisTemplate;

    public GithubService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    //    private final ResidentRepository residentRepository;
//
//    public GithubService(ResidentRepository residentRepository) {
//        this.residentRepository = residentRepository;
//    }

    private final String baseUrl = "https://github.com/login/oauth/access_token";
    private final String client_id = "a1f50437553075286e71";
    private final String client_secret = "53b4ccad0550ee1c448a4024f770acdd8cf0f873";

    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpHeaders headers = new HttpHeaders();
    private HttpEntity httpEntity;

    public GithubUserInfo githubOauthCallback(String code) throws JsonProcessingException {

        UriComponents url = createAccessTokenUri(code);

        headers.setContentType(MediaType.APPLICATION_JSON);
        httpEntity = new HttpEntity(headers);

        ResponseEntity<GitHub> result = restTemplate.exchange(
                url.toUriString(),
                HttpMethod.POST,
                httpEntity,
                GitHub.class
        );
        return getUserInfoByAccessToken(result.getBody().getAccess_token());
    }

    public void registerAuthenticationToken(Resident resident, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SecurityContext securityContext = SecurityContextHolder.getContext();

        User userDetails = getUserDetails(resident);

        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities()
        );

        securityContext.setAuthentication(authenticationToken);
        SecurityContextHolder.setContext(securityContext);

        LoginSuccessHandler successHandler = new LoginSuccessHandler(redisTemplate);

        successHandler.onAuthenticationSuccess(request, response, authenticationToken);
    }


    private GithubUserInfo getUserInfoByAccessToken(String accessToken) throws JsonProcessingException {
        headers.clear();
        headers.add("Authorization", "Bearer " + accessToken);
        httpEntity= new HttpEntity(headers);

        ResponseEntity<GithubUserInfo> result = restTemplate.exchange(
                "https://api.github.com/user",
                HttpMethod.GET,
                httpEntity,
                GithubUserInfo.class
        );

        return result.getBody();
    }

    private UriComponents createAccessTokenUri(String code) {
        UriComponents url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("client_id", client_id)
                .queryParam("client_secret", client_secret)
                .queryParam("code", code)
                .build();
        return url;
    }

    private User getUserDetails(Resident resident) {
        return new User(
                resident.getResidentId(),
                resident.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("Resident"))
        );
    }

}
