package com.najinji.ohmymoneyserver.domain.place;

import static com.najinji.ohmymoneyserver.domain.place.QPlace.place;

import lombok.RequiredArgsConstructor;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@RequiredArgsConstructor
@Repository
public class PlaceQueryRepository {
    private final JPAQueryFactory queryFactory;

    public Place findByName(String name) {
        List<Place> places = new ArrayList<>();
        places = queryFactory
                .selectFrom(place)
                .where(place.name.eq(name))
                .fetch();
        return places.get(0);
    }
}