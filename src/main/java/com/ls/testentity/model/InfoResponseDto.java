package com.ls.testentity.model;

import com.ls.testentity.emun.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoResponseDto {

    private Long id;
    private String name;
    private Gender gender;
    private String email;
    private String phone;
}
