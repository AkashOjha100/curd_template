package com.ls.testentity.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Register extends InfoID {


    @Column(nullable = false,length = 100)
    private String name;

    @Column(nullable = false,unique = true,length = 100)
    private String username;

    @Column(nullable = false,length = 255)
    private String password;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private Long phone_no;

    private boolean deleted=Boolean.FALSE;
}
