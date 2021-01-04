package com.najinji.ohmymoneyserver.domain.place;

import com.najinji.ohmymoneyserver.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor
@Entity
public class Place extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String tag;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Builder
    public Place(String name, String address, String newAddress, String phone, String tag, Category category) {
        this.name = name;
        this.address = newAddress;
        this.phone = phone;
        this.tag = tag;
        this.category = category;
    }

    public String getCategoryKey() {
        return this.category.getKey();
    }
}
