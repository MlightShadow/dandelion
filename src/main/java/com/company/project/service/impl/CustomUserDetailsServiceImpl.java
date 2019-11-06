package com.company.project.service.impl;

import com.company.project.dto.AuthorizedInfo;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component(value = "CustomUserDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Override
    public AuthorizedInfo loadUserByUsername(String name) throws UsernameNotFoundException {
        AuthorizedInfo a = new AuthorizedInfo("", "", "");
        return a;
    }
}
