package com.najinji.ohmymoneyserver.domain.redis.redisplace;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RedisPlaceRepository extends CrudRepository<RedisPlace, String> {
    @Override
    List<RedisPlace> findAll();
}
