package com.najinji.ohmymoneyserver.web.dto.place;

import lombok.Getter;

import com.najinji.ohmymoneyserver.domain.place.Place;
import com.najinji.ohmymoneyserver.domain.place.Category;

@Getter
public class PlaceResponseDto {

    private Long id;
    private Category category;
    private String name;
    private String address;
    private String phone;
    private String tag;
    private String url;

    public PlaceResponseDto(Place entity) {
        this.id = entity.getId();
        this.category = entity.getCategory();
        this.name = entity.getName();
        this.address = entity.getAddress();
        this.phone = entity.getPhone();
        this.tag = entity.getTag();
        this.url = entity.getUrl();
    }
}
