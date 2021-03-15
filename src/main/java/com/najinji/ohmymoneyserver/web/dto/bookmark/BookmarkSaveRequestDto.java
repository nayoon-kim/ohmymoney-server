package com.najinji.ohmymoneyserver.web.dto.bookmark;

import com.najinji.ohmymoneyserver.domain.bookmark.Bookmark;
import com.najinji.ohmymoneyserver.domain.place.Place;
import com.najinji.ohmymoneyserver.domain.user.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookmarkSaveRequestDto {

    private Place place;
    private User user;

    @Builder
    public BookmarkSaveRequestDto(Place place, User user) {
        this.place = place;
        this.user = user;
    }

    public Bookmark toEntity() {
        return Bookmark.builder()
                .place(place)
                .user(user)
                .build();
    }
}
