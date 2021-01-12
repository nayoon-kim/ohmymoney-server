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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String tag;

    @Column
    private String url;

    @Builder
    public Place(Category category, String name, String address, String newAddress, String phone, String tag, String url) {
        this.category = category;
        this.name = name;
        this.address = newAddress;
        this.phone = phone;
        this.tag = tag;
        this.url = url;
    }

    public Place update(String name, String address, String phone, String tag, String url) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.tag = tag;
        this.url = url;
        return this;
    }

    public String getCategoryKey() {
        return this.category.getKey();
    }
}
