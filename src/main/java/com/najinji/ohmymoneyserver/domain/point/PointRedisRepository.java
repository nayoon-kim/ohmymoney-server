package com.najinji.ohmymoneyserver.domain.point;

import org.springframework.data.repository.CrudRepository;

public interface PointRedisRepository extends CrudRepository<Point, String> {
}
