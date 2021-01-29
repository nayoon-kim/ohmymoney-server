package com.najinji.ohmymoneyserver.domain.picture;

import static com.najinji.ohmymoneyserver.domain.picture.QPicture.picture;
import static com.najinji.ohmymoneyserver.domain.place.QPlace.place;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;
import java.util.ArrayList;

@RequiredArgsConstructor
@Repository
public class PictureQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<Picture> findByPlaceId(Long id) {
        List<Picture> pictures = new ArrayList<>();
        pictures = queryFactory
                .selectFrom(picture)
                .leftJoin(place, picture.place)
                .fetch();
        return pictures;
    }
}
