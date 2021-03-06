package com.najinji.ohmymoneyserver.web.dto.place;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Builder;

@Getter
@NoArgsConstructor
public class PlaceUpdateRequestDto {

    private String name;
    private String address;
    private String phone;
    private String tag;
    private String url;
    private String sum;
    private String details;
    private Double latitude;
    private Double longitude;

    @Builder
    public PlaceUpdateRequestDto(String name, String address, String phone, String tag, String url, String sum, String details, Double latitude, Double longitude) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.tag = tag;
        this.url = url;
        this.sum = sum;
        this.details = details;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
