package com.ls.testentity.service;

import com.ls.testentity.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomRegisterDetailsService implements UserDetailsService {

    private final RegisterRepository registerRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return (UserDetails) registerRepository.findByUsername(username).orElseThrow();
    }
}
