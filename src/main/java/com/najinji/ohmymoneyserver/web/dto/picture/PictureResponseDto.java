package com.najinji.ohmymoneyserver.web.dto.picture;

import com.najinji.ohmymoneyserver.domain.place.Place;
import com.najinji.ohmymoneyserver.domain.picture.Picture;

public class PictureResponseDto {

    private Long id;
    private String url;
    private Place place;

    public PictureResponseDto(Picture entity) {
        this.id = entity.getId();
        this.url = entity.getUrl();
        this.place = entity.getPlace();
    }
}
