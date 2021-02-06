package com.najinji.ohmymoneyserver.domain.place;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlaceRepositoryTest {

    @Autowired
    PlaceQueryRepository placeQueryRepository;

    @Autowired
    PlaceRepository placeRepository;

    @Test
    public void 장소_불러오기() {
//        List<Place> placeList = placeRepository.findAll();
//
//        assertThat(placeList.size()).isEqualTo(330);
    }
}
