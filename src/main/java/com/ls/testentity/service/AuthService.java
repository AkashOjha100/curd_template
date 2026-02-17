package com.ls.testentity.service;

import com.ls.testentity.entity.Register;
import com.ls.testentity.model.LoginRequestDto;
import com.ls.testentity.model.LoginResponseDto;
import com.ls.testentity.model.RegisterResponseDto;
import com.ls.testentity.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RegisterRepository registerRepository;

    public LoginResponseDto login(LoginRequestDto loginRequestDto){
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),loginRequestDto.getPassword())
        );
        Register register=(Register) authentication.getPrincipal();
        String token = jwtService.generateToken(register);

        return new LoginResponseDto(
                token,
                register.getId(),
                register.getName(),
                register.getPhone_no()
        );

    }
}
