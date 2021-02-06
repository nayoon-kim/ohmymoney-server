package com.najinji.ohmymoneyserver.domain.picture;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    List<Picture> findByIdIn(List<Long> ids);
}
