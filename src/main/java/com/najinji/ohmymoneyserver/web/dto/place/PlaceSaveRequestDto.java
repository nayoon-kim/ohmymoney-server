package com.najinji.ohmymoneyserver.web.dto.place;

import com.najinji.ohmymoneyserver.domain.place.Place;
import com.najinji.ohmymoneyserver.domain.place.Category;

import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlaceSaveRequestDto {

    private Category category;
    private String name;
    private String address;
    private String phone;
    private String tag;

    @Builder
    public PlaceSaveRequestDto(Category category, String name, String address, String phone, String tag) {
        this.category = category;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.tag = tag;
    }

    public Place toEntity() {
        return Place.builder()
                .name(name)
                .address(address)
                .phone(phone)
                .tag(tag)
                .build();
    }
}
