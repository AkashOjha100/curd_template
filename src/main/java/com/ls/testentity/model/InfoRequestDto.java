package com.ls.testentity.model;

import com.ls.testentity.emun.Gender;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoRequestDto {

    @NotBlank(message = "Name is Required ")
    private String name;

    @Email
    @NotBlank(message = "Email must be required ")
    private String email;

    @NotBlank(message = "Gender must be required")
    //@NotBlank(message = "Gender should be either M or F")
    private String gender;

    @Size(min=10,max = 14,message = "Number start with be either 1234567890 or +91 1234567890 ")
    private String phone;
}
