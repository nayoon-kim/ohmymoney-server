package com.najinji.ohmymoneyserver.domain.user;

import com.najinji.ohmymoneyserver.domain.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private Type type;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

//    @Enumerated(EnumType.STRING)
//    @Column
//    private Role role;

    @Column
    private int age;

    @Column
    private String residence;

    @Builder
    public User(Type type, String name, String email, Gender gender, String picture) {
        this.type = type;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.picture = picture;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;
        return this;
    }

    public User update(Gender gender, int age, String residence) {
        this.gender = gender;
        this.age = age;
        this.residence = residence;
        return this;
    }

    public String getAccessType() { return this.type.getAccessType(); }
//    public String getRoleKey() { return this.role.getKey(); }
}
