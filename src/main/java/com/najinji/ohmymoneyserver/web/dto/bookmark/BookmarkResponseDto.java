package com.najinji.ohmymoneyserver.web.dto.bookmark;

import lombok.Getter;

import com.najinji.ohmymoneyserver.domain.user.User;
import com.najinji.ohmymoneyserver.domain.place.Place;
import com.najinji.ohmymoneyserver.domain.bookmark.Bookmark;

@Getter
public class BookmarkResponseDto {

    private Long id;
    private User user;
    private Place place;

    public BookmarkResponseDto(Bookmark entity) {
        this.id = entity.getId();
        this.user = entity.getUser();
        this.place = entity.getPlace();
    }
}
