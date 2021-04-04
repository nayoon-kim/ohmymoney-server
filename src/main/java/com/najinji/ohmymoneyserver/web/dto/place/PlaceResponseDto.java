package com.najinji.ohmymoneyserver.web.dto.place;

import com.najinji.ohmymoneyserver.domain.picture.Picture;
import lombok.Getter;

import com.najinji.ohmymoneyserver.domain.place.Place;

import java.util.Collection;
import java.util.List;

@Getter
public class PlaceResponseDto {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private String tag;
    private String url;
    private String sum;
    private String details;
    private Double latitude;
    private Double longitude;
    private List<Picture> picture;

    public PlaceResponseDto(Place entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.address = entity.getAddress();
        this.phone = entity.getPhone();
        this.tag = entity.getTag();
        this.url = entity.getUrl();
        this.sum = entity.getSum();
        this.details = entity.getDetails();
        this.latitude = entity.getLatitude();
        this.longitude = entity.getLongitude();
        this.picture = entity.getPicture();
    }

    public String toString() {
        String str = "PlaceResponseDto [id= " + String.valueOf(id) + ", picture= ";

        for (Picture p : picture) {
            str += p.getUrl() + " ";
        }

        str += "]";
        return str;
    }
}
