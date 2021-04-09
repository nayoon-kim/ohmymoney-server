package com.najinji.ohmymoneyserver.domain.redis.redisplace;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Getter
@RedisHash("places")
public class RedisPlace implements Serializable {
    @Id
    private String id;
    private List<String> places;

    @Builder
    public RedisPlace(String id, List<String> places) {
        this.id = id;
        this.places = places;
    }

    public void update(List<String> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "RedisPlace id: " + id + ", places: " + places.toString();
    }
}
