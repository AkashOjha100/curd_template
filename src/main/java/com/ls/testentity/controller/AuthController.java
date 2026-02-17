package com.ls.testentity.controller;

import com.ls.testentity.model.LoginRequestDto;
import com.ls.testentity.model.LoginResponseDto;
import com.ls.testentity.model.RegisterRequestDto;
import com.ls.testentity.model.RegisterResponseDto;
import com.ls.testentity.service.AuthService;
import com.ls.testentity.service.JwtService;
import com.ls.testentity.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/auth/ino")
@RestController
public class AuthController {

    private final RegisterService registerService;
    private final AuthenticationManager authenticationManager;
    //private final JwtService jwtService;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto requestDto){
        return ResponseEntity.ok(authService.login(requestDto));
    }

    @PostMapping("/register")
    public List<RegisterResponseDto> registerUsers(
            @RequestBody List<RegisterRequestDto> registerRequestDto){
        //RegisterResponseDto responseDto=registerService.AddRegister(registerRequestDto);
        return registerService.AddRegister(registerRequestDto);
                //ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<RegisterResponseDto>> getRegisterDetails() {
        return ResponseEntity.ok(registerService.getRegisterDetails());
    }

    @GetMapping("/{id}")
    public RegisterResponseDto getDetailsById(@PathVariable Long id){
        return registerService.getDetailsById(id);
    }

    @PutMapping("/{id}")
    public RegisterResponseDto updateRegister(@PathVariable Long id,@RequestBody RegisterRequestDto requestDto){
        return registerService.updateRegister(id,requestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRegisterDetail(@PathVariable Long id) {
        registerService.remove(id);
        return ResponseEntity.ok("Information soft deleted successfully 😊");
    }
}
