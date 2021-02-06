package com.najinji.ohmymoneyserver.web.dto.picture;

import lombok.Getter;

import com.najinji.ohmymoneyserver.domain.place.Place;
import com.najinji.ohmymoneyserver.domain.picture.Picture;

@Getter
public class PictureResponseDto {

    private Long id;
    private String url;
    private Long place_id;

    public PictureResponseDto(Picture entity) {
        this.id = entity.getId();
        this.url = entity.getUrl();
        this.place_id = entity.getPlace_id();
    }
}
