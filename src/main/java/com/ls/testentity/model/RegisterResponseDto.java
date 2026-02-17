package com.ls.testentity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponseDto {

    private Long id;
    private String name;
    private String username;
    private String email;
    private Long phone_no;
    //private String token;
}
