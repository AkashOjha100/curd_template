package com.ls.testentity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

    String token;
    Long registerId;
    String name;
    Long phone_no;
}
