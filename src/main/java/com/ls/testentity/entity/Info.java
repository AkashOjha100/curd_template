package com.ls.testentity.entity;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.ls.testentity.emun.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

@Entity
@Getter
@Setter
@SQLDelete(sql="UPDATE info set deleted = true WHERE id = ?")
public class Info extends InfoID {


    @Column(nullable = false,length = 60)
    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private String phone;

    private boolean deleted=Boolean.FALSE;


}
