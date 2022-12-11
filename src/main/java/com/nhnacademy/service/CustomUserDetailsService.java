package com.nhnacademy.service;

import com.nhnacademy.entity.Resident;
import com.nhnacademy.repository.ResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final ResidentRepository residentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Resident resident = residentRepository.findByResidentId(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + "not found"));


        return new User(
                resident.getResidentId(),
                resident.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("Resident")));
    }

}
