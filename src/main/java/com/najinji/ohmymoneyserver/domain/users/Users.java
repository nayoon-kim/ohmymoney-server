package com.najinji.ohmymoneyserver.domain.users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable=false)
    private String name;

    @Column(nullable = false)
    private String loginname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private int gender;

    @Column(nullable = true)
    private int age;

    @Builder
    public Users(String name, String loginname, String password, int gender, int age){
        this.name = name;
        this.loginname = loginname;
        this.password = password;
        this.gender = gender;
        this.age = age;
    }

}
