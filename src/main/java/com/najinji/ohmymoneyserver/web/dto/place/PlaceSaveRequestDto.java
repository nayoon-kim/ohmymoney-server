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
    private String sum;
    private String details;

    @Builder
    public PlaceSaveRequestDto(Category category, String name, String address, String phone, String tag, String sum, String details) {
        this.category = category;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.tag = tag;
        this.sum = sum;
        this.details = details;
    }

    public Place toEntity() {
        return Place.builder()
                .name(name)
                .address(address)
                .phone(phone)
                .tag(tag)
                .sum(sum)
                .details(details)
                .build();
    }
}
