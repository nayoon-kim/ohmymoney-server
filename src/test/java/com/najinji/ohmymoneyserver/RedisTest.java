package com.najinji.ohmymoneyserver;

import com.najinji.ohmymoneyserver.domain.point.Point;
import com.najinji.ohmymoneyserver.domain.point.PointRedisRepository;
import org.junit.After;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private PointRedisRepository pointRedisRepository;

    @After
    public void tearDown() throws Exception {
        pointRedisRepository.deleteAll();
    }

    @Test
    public void 기본_등록_조회기능() {
        // given
        String id = "nayoon";
        LocalDateTime refreshTime = LocalDateTime.of(2021, 3, 31, 12, 32);
        Point point = Point.builder()
                .id(id)
                .amount(1000L)
                .refreshTime(refreshTime)
                .build();

        // when
        pointRedisRepository.save(point);

        // then
        Point savedPoint = pointRedisRepository.findById(id).get();
        assertThat(savedPoint.getAmount(), is(1000L));
        assertThat(savedPoint.getRefreshTime(), is(refreshTime));
    }

    @Test
    public void 수정기능() {
        // given
        String id = "nayoon";
        LocalDateTime refreshTime = LocalDateTime.of(2021, 3, 31, 0, 0, 0);
        Point point = Point.builder()
                .id(id)
                .amount(1000L)
                .refreshTime(refreshTime)
                .build();
        pointRedisRepository.save(point);

        // when
        Point savedPoint = pointRedisRepository.findById(id).get();
        savedPoint.refresh(2000L, LocalDateTime.of(2021, 4, 1, 0, 0, 0));
        pointRedisRepository.save(savedPoint);

        // then
        Point refreshPoint = pointRedisRepository.findById(id).get();
        assertThat(refreshPoint.getAmount(), is(2000L));
    }
}
