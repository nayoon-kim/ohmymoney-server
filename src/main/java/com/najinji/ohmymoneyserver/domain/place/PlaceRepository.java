package com.najinji.ohmymoneyserver.domain.place;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findByNameContaining(String q);
    List<Place> findByNameIn(List<String> names);
}