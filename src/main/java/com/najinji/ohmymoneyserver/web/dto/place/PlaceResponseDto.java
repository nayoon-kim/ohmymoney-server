package com.najinji.ohmymoneyserver.web.dto.place;

import lombok.Getter;

import com.najinji.ohmymoneyserver.domain.place.Place;

@Getter
public class PlaceResponseDto {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private String tag;

    public PlaceResponseDto(Place entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.address = entity.getAddress();
        this.phone = entity.getPhone();
        this.tag = entity.getTag();
    }
}
