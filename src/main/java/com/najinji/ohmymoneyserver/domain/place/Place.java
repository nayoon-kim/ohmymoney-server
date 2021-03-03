package com.najinji.ohmymoneyserver.domain.place;

import com.najinji.ohmymoneyserver.domain.BaseTimeEntity;
import com.najinji.ohmymoneyserver.domain.picture.Picture;

import java.util.Collection;

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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

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

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String tag;

    @Column
    private String url;

    @Column(length=500)
    private String sum;

    @Column(length=2000)
    private String details;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="place_id")
    private Collection<Picture> picture;

    @Builder
    public Place(Category category, String name, String address, String newAddress, String phone, String tag, String url, String sum, String details, Double latitude, Double longitude) {
        this.category = category;
        this.name = name;
        this.address = newAddress;
        this.phone = phone;
        this.tag = tag;
        this.url = url;
        this.sum = sum;
        this.details = details;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Place update(String name, String address, String phone, String tag, String url, String sum, String details, Double longitude, Double latitude) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.tag = tag;
        this.url = url;
        this.sum = sum;
        this.details = details;
        this.latitude = latitude;
        this.longitude = longitude;
        return this;
    }

    public String getCategoryKey() {
        return this.category.getKey();
    }
}
