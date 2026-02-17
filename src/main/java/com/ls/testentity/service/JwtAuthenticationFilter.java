package com.ls.testentity.service;

import com.ls.testentity.entity.Register;
import com.ls.testentity.repository.RegisterRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    //private final CustomRegisterDetailsService customRegisterDetailsService;
    private final RegisterRepository registerRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.split("Bearer ")[1];
        String username = jwtService.extractUsername(token);

        if(username !=null && SecurityContextHolder.getContext().getAuthentication() == null){
            Register register = registerRepository.findByUsername(username).orElseThrow();
            UsernamePasswordAuthenticationToken appToken =new UsernamePasswordAuthenticationToken(register,null,register.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(appToken);

        }
        filterChain.doFilter(request,response);
    }
}
