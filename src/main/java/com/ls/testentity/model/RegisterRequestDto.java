package com.ls.testentity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterRequestDto {

    private String name;
    private String username;
    private String password;
    private String email;
    private Long phone_no;
}
